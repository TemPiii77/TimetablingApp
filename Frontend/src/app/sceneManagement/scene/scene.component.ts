import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {SceneDto} from "../../dto/scene-dto";
import {SceneService} from "../../service/scene.service";
import {SubjectDto} from "../../dto/subject-dto";
import {SubjectService} from "../../service/subject.service";

@Component({
  selector: 'app-scene',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './scene.component.html',
  styleUrl: './scene.component.css'
})
export class SceneComponent implements OnInit{

  scenes: SceneDto[] = [];
  subjects: SubjectDto[] = [];
  defaultScene: SceneDto | undefined;

  sceneForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl(''),
    subject: new FormControl(<SubjectDto | null>null),
  })

  constructor(private sceneService: SceneService,
              private subjectService: SubjectService) {}

  ngOnInit(): void {
    this.sceneService.listScenes();
    this.subjectService.listSubjects();

    this.sceneService.scenes$.subscribe(resultData => {
      this.scenes = resultData;
    });

    this.subjectService.subjects$.subscribe(resultData => {
      this.subjects = resultData;
    });
  }

  saveScene(newScene: SceneDto): void {
    this.sceneService.saveScene(newScene)
    this.sceneService.listScenes();
  }

  deleteScene(id: number): void {
    this.sceneService.deleteScene(id).subscribe(() => {
      this.sceneService.listScenes();
    });
  }

  updateScene(updatedScene: SceneDto): void {
    this.sceneService.updateScene(updatedScene)
    this.sceneService.listScenes();
  }

  handleSubmit(event: any) {
    const scene = {
      id: this.sceneForm.value.id ? Number(this.sceneForm.value.id) : 0,
      name: this.sceneForm.value.name!,
      subject: this.sceneForm.value.subject!
    };

    if(event.submitter.name == "save") {
      this.sceneForm.get('id')?.setValue(null);
      scene.id = 0;
      this.saveScene(scene);
    }
    else if(event.submitter.name == "update") {
      this.updateScene(scene);
      this.sceneForm.get('id')?.setValue(null);
    }
  }

  updateSceneForm(scene: SceneDto) {
    this.defaultScene = scene;

    this.sceneForm.patchValue({
      id: this.defaultScene.id!.toString(),
      name: this.defaultScene.name,
      subject: this.defaultScene.subject,
    });
  }

}
