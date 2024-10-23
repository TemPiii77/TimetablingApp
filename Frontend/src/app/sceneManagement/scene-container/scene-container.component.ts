import { Component } from '@angular/core';
import {SceneComponent} from "../scene/scene.component";
import {ScenePartComponent} from "../scene-part/scene-part.component";
import {SceneCommentComponent} from "../scene-comment/scene-comment.component";
import {ClassSceneComponent} from "../class-scene/class-scene.component";
import {TeacherSceneComponent} from "../teacher-scene/teacher-scene.component";

@Component({
  selector: 'app-scene-container',
  standalone: true,
  imports: [
    SceneComponent,
    ScenePartComponent,
    SceneCommentComponent,
    ClassSceneComponent,
    TeacherSceneComponent
  ],
  templateUrl: './scene-container.component.html',
  styleUrl: './scene-container.component.css'
})
export class SceneContainerComponent {

}
