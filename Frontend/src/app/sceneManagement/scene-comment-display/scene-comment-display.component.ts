import {Component, OnInit} from '@angular/core';
import {ScenePartDto} from "../../dto/scene-part-dto";
import {SceneDto} from "../../dto/scene-dto";
import {ScenePartService} from "../../service/scene-part.service";
import {ActivatedRoute, Router} from "@angular/router";
import {SceneCommentDto} from "../../dto/scene-comment-dto";
import {SceneCommentService} from "../../service/scene-comment.service";
import {DatePipe} from "@angular/common";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {UserDto} from "../../dto/user-dto";
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-scene-comment-display',
  standalone: true,
  imports: [
    DatePipe,
    ReactiveFormsModule
  ],
  templateUrl: './scene-comment-display.component.html',
  styleUrl: './scene-comment-display.component.css'
})
export class SceneCommentDisplayComponent implements OnInit{

  sceneComments: SceneCommentDto[] = [];
  scenePart: ScenePartDto | undefined;
  scenePartId: Number | undefined;


  sceneCommentForm = new FormGroup({
    id: new FormControl(''),
    content: new FormControl(''),
    dateRecorded: new FormControl(<Date | null>null),
    user: new FormControl(<UserDto | null>null),
    scenePart: new FormControl(<ScenePartDto | null>null),
  })

  constructor(private sceneCommentService: SceneCommentService,
              private route: ActivatedRoute,
              private authService: AuthService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.scenePartId = Number(params.get('id'));

      this.sceneCommentService.listSceneComment(this.scenePartId)
    });

    this.sceneCommentService.sceneComments$.subscribe(resultData => {
      this.sceneComments = resultData;

      if (this.sceneComments && this.sceneComments.length > 0) {
        this.scenePart = this.sceneComments[0].scenePart;
      }
    });
  }

  saveSceneComment(newSceneComment: SceneCommentDto): void {
    this.sceneCommentService.saveSceneComment(newSceneComment)
    this.sceneCommentService.listSceneComments();
    //window.location.reload();
  }

  handleSubmit(event: any) {
    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      const sceneComment = {
        id: this.sceneCommentForm.value.id ? Number(this.sceneCommentForm.value.id) : 0,
        content: this.sceneCommentForm.value.content!,
        dateRecorded: this.sceneCommentForm.value.dateRecorded!,
        user: user,
        scenePart: this.scenePart!
      };

      sceneComment.dateRecorded = new Date();
      this.sceneCommentForm.get('id')?.setValue(null);
      sceneComment.id = 0;
      this.saveSceneComment(sceneComment);
    });
  }

  getTimestampInMilliseconds(dateRecorded: Date | undefined): number {
    return Number(dateRecorded) * 1000;
  }
}
