import {Component, OnInit} from '@angular/core';
import {SceneDto} from "../../dto/scene-dto";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {SceneService} from "../../service/scene.service";
import {ScenePartDto} from "../../dto/scene-part-dto";
import {ScenePartService} from "../../service/scene-part.service";

@Component({
  selector: 'app-scene-part',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './scene-part.component.html',
  styleUrl: './scene-part.component.css'
})
export class ScenePartComponent implements OnInit{

  scenes: SceneDto[] = [];
  sceneParts: ScenePartDto[] = [];
  defaultscenePart: ScenePartDto | undefined;

  scenePartForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl(''),
    news: new FormControl(<boolean | null>null),
    scene: new FormControl(<SceneDto | null>null),
  })

  constructor(private scenePartService: ScenePartService,
              private sceneService: SceneService) {}

  ngOnInit(): void {
    this.scenePartService.listSceneParts();
    this.sceneService.listScenes();

    this.scenePartService.sceneParts$.subscribe(resultData => {
      this.sceneParts = resultData;
    });

    this.sceneService.scenes$.subscribe(resultData => {
      this.scenes = resultData;
    });
  }

  saveScenePart(newScenePart: ScenePartDto): void {
    this.scenePartService.saveScenePart(newScenePart)
    this.scenePartService.listSceneParts();
  }

  deleteScenePart(id: number): void {
    this.scenePartService.deleteScenePart(id).subscribe(() => {
      this.scenePartService.listSceneParts();
    });
  }

  updateScenePart(updatedScenePart: ScenePartDto): void {
    this.scenePartService.updateScenePart(updatedScenePart)
    this.scenePartService.listSceneParts();
  }

  handleSubmit(event: any) {
    const scenePart = {
      id: this.scenePartForm.value.id ? Number(this.scenePartForm.value.id) : 0,
      name: this.scenePartForm.value.name!,
      news: this.scenePartForm.value.news!,
      scene: this.scenePartForm.value.scene!
    };

    if(event.submitter.name == "save") {
      console.log(scenePart)
      this.scenePartForm.get('id')?.setValue(null);
      scenePart.id = 0;
      this.saveScenePart(scenePart);
    }
    else if(event.submitter.name == "update") {
      this.updateScenePart(scenePart);
      this.scenePartForm.get('id')?.setValue(null);
    }
  }

  updateSceneForm(scenePart: ScenePartDto) {
    this.defaultscenePart = scenePart;

    this.scenePartForm.patchValue({
      id: this.defaultscenePart.id!.toString(),
      name: this.defaultscenePart.name,
      news: this.defaultscenePart.news,
      scene: this.defaultscenePart.scene,
    });
  }


}
