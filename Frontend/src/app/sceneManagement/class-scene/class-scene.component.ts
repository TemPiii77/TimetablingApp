import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {ClassSceneDto} from "../../dto/class-scene-dto";
import {ClassSceneIdDto} from "../../dto/class-scene-id-dto";
import {ClassSceneService} from "../../service/class-scene.service";
import {ClassDto} from "../../dto/class-dto";
import {ClassService} from "../../service/class.service";
import {SceneDto} from "../../dto/scene-dto";
import {SceneService} from "../../service/scene.service";

@Component({
  selector: 'app-class-scene',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './class-scene.component.html',
  styleUrl: './class-scene.component.css'
})
export class ClassSceneComponent implements OnInit {

  classScenes: ClassSceneDto[] = [];
  classes: ClassDto[] = [];
  scenes: SceneDto[] = [];

  classSceneForm = new FormGroup({
    classId: new FormControl(''),
    sceneId: new FormControl(''),
  })

  constructor(private classSceneService: ClassSceneService,
              private classService: ClassService,
              private sceneService: SceneService) {}

  ngOnInit(): void {
    this.classSceneService.listClassScenes();
    this.classService.listClasses();
    this.sceneService.listScenes();

    this.classSceneService.classScenes$.subscribe(resultData => {
      this.classScenes = resultData;
    });

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;
    });

    this.sceneService.scenes$.subscribe(resultData => {
      this.scenes = resultData;
    });
  }

  saveclassScene(newclassSceneId: ClassSceneIdDto): void {
    this.classSceneService.updateClassScene(newclassSceneId)
    this.classSceneService.listClassScenes();
  }

  deleteclassScene(classId: number, sceneId: number): void {
    this.classSceneService.deleteClassScene(classId, sceneId).subscribe(() => {
      this.classSceneService.listClassScenes();
    });
  }

  updateclassScene(updatedclassSceneId: ClassSceneIdDto): void {
    this.classSceneService.updateClassScene(updatedclassSceneId)
    this.classSceneService.listClassScenes();
  }

  handleSubmit(event: any) {
    const subjectSubjectRequirementId = {
      classId: this.classSceneForm.value.classId ? Number(this.classSceneForm.value.classId) : 0,
      sceneId: this.classSceneForm.value.sceneId ? Number(this.classSceneForm.value.sceneId) : 0
    };

    if(event.submitter.name == "save") {
      this.saveclassScene(subjectSubjectRequirementId);
    }
    else if(event.submitter.name == "update") {
      this.updateclassScene(subjectSubjectRequirementId);
    }
  }

  formatFields(subjectRequirement: any): string {
    return Object.values(subjectRequirement).join(' - ');
  }

}
