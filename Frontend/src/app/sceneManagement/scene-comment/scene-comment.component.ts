import {Component, OnInit} from '@angular/core';
import {ScenePartDto} from "../../dto/scene-part-dto";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {ScenePartService} from "../../service/scene-part.service";
import {SceneCommentDto} from "../../dto/scene-comment-dto";
import {SceneCommentService} from "../../service/scene-comment.service";
import {UserDto} from "../../dto/user-dto";
import {UserService} from "../../service/user.service";
import {timestamp} from "rxjs";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-scene-comment',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    DatePipe
  ],
  templateUrl: './scene-comment.component.html',
  styleUrl: './scene-comment.component.css'
})
export class SceneCommentComponent implements OnInit{

  sceneParts: ScenePartDto[] = [];
  users: UserDto[] = [];
  sceneComments: SceneCommentDto[] = [];
  defaultsceneComment: SceneCommentDto | undefined;

  sceneCommentForm = new FormGroup({
    id: new FormControl(''),
    content: new FormControl(''),
    dateRecorded: new FormControl(<Date | null>null),
    user: new FormControl(<UserDto | null>null),
    scenePart: new FormControl(<ScenePartDto | null>null),
  })

  constructor(private scenePartService: ScenePartService,
              private sceneCommentService: SceneCommentService,
              private userService: UserService) {}

  ngOnInit(): void {
    this.sceneCommentService.listSceneComments();
    this.scenePartService.listSceneParts();
    this.userService.listUsers();

    this.sceneCommentService.sceneComments$.subscribe(resultData => {
      this.sceneComments = resultData;
    });

    this.scenePartService.sceneParts$.subscribe(resultData => {
      this.sceneParts = resultData;
    });

    this.userService.users$.subscribe(resultData => {
      this.users = resultData;
    });
  }

  saveSceneComment(newSceneComment: SceneCommentDto): void {
    this.sceneCommentService.saveSceneComment(newSceneComment)
    this.sceneCommentService.listSceneComments();
  }

  deleteSceneComment(id: number): void {
    this.sceneCommentService.deleteSceneComment(id).subscribe(() => {
      this.sceneCommentService.listSceneComments();
    });
  }

  updateSceneComment(updatedSceneComment: SceneCommentDto): void {
    this.sceneCommentService.updateSceneComment(updatedSceneComment)
    this.sceneCommentService.listSceneComments();
  }

  handleSubmit(event: any) {
    const sceneComment = {
      id: this.sceneCommentForm.value.id ? Number(this.sceneCommentForm.value.id) : 0,
      content: this.sceneCommentForm.value.content!,
      dateRecorded: this.sceneCommentForm.value.dateRecorded!,
      user: this.sceneCommentForm.value.user!,
      scenePart: this.sceneCommentForm.value.scenePart!
    };

    if(event.submitter.name == "save") {
      sceneComment.dateRecorded = new Date();
      this.sceneCommentForm.get('id')?.setValue(null);
      sceneComment.id = 0;
      this.saveSceneComment(sceneComment);
    }
    else if(event.submitter.name == "update") {
      this.updateSceneComment(sceneComment);
      this.sceneCommentForm.get('id')?.setValue(null);
    }
  }

  updateSceneForm(sceneComment: SceneCommentDto) {
    this.defaultsceneComment = sceneComment;

    this.sceneCommentForm.patchValue({
      id: this.defaultsceneComment.id!.toString(),
      content: this.defaultsceneComment.content,
      dateRecorded: this.defaultsceneComment.dateRecorded,
      user: this.defaultsceneComment.user,
      scenePart: this.defaultsceneComment.scenePart,
    });
  }


  getTimestampInMilliseconds(dateRecorded: Date | undefined): number {
    return Number(dateRecorded) * 1000;
  }
}
