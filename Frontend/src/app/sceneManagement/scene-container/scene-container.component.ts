import { Component } from '@angular/core';
import {SceneComponent} from "../scene/scene.component";
import {ScenePartComponent} from "../scene-part/scene-part.component";
import {SceneCommentComponent} from "../scene-comment/scene-comment.component";

@Component({
  selector: 'app-scene-container',
  standalone: true,
  imports: [
    SceneComponent,
    ScenePartComponent,
    SceneCommentComponent
  ],
  templateUrl: './scene-container.component.html',
  styleUrl: './scene-container.component.css'
})
export class SceneContainerComponent {

}
