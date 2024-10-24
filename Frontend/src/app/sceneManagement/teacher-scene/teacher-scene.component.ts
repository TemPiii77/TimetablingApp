import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {TeacherSceneDto} from "../../dto/teacher-scene-dto";
import {TeacherSceneIdDto} from "../../dto/teacher-scene-id-dto";
import {TeacherSceneService} from "../../service/teacher-scene.service";
import {TeacherDto} from "../../dto/teacher-dto";
import {TeacherService} from "../../service/teacher.service";
import {SceneDto} from "../../dto/scene-dto";
import {SceneService} from "../../service/scene.service";

@Component({
  selector: 'app-teacher-scene',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './teacher-scene.component.html',
  styleUrl: './teacher-scene.component.css'
})
export class TeacherSceneComponent implements OnInit {

  teacherScenes: TeacherSceneDto[] = [];
  teachers: TeacherDto[] = [];
  scenes: SceneDto[] = [];

  teacherSceneIdForm = new FormGroup({
    teacherId: new FormControl(''),
    sceneId: new FormControl(''),
  })

  constructor(private teacherSceneService: TeacherSceneService,
              private teacherService: TeacherService,
              private sceneService: SceneService) {}

  ngOnInit(): void {
    this.teacherSceneService.listTeacherScenes();
    this.teacherService.listTeachers();
    this.sceneService.listScenes();

    this.teacherSceneService.teacherScenes$.subscribe(resultData => {
      this.teacherScenes = resultData;
    });

    this.teacherService.teachers$.subscribe(resultData => {
      this.teachers = resultData;
    });

    this.sceneService.scenes$.subscribe(resultData => {
      this.scenes = resultData;
    });
  }

  saveTeacherScene(newTeacherSceneId: TeacherSceneIdDto): void {
    this.teacherSceneService.saveTeacherScene(newTeacherSceneId)
    this.teacherSceneService.listTeacherScenes();
  }

  deleteTeacherScene(teacherId: string, sceneId: number): void {
    this.teacherSceneService.deleteTeacherScene(teacherId, sceneId).subscribe(() => {
      this.teacherSceneService.listTeacherScenes();
    });
  }

  updateTeacherScene(updatedTeacherSceneId: TeacherSceneIdDto): void {
    this.teacherSceneService.updateTeacherScene(updatedTeacherSceneId)
    this.teacherSceneService.listTeacherScenes();
  }

  handleSubmit(event: any) {
    const teacherSceneId = {
      teacherId: this.teacherSceneIdForm.value.teacherId!,
      sceneId: this.teacherSceneIdForm.value.sceneId ? Number(this.teacherSceneIdForm.value.sceneId) : 0
    };

    if(event.submitter.name == "save") {
      this.saveTeacherScene(teacherSceneId);
    }
    else if(event.submitter.name == "update") {
      this.updateTeacherScene(teacherSceneId);
    }
  }

  formatFields(fields: any): string {
    return Object.values(fields).join(' - ');
  }

}
