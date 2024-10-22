import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {SceneCommentDto} from "../dto/scene-comment-dto";

@Injectable({
  providedIn: 'root'
})
export class SceneCommentService {

  private sceneCommentsSubject = new BehaviorSubject<SceneCommentDto[]>([]);
  sceneComments$ = this.sceneCommentsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listSceneComments(): void {
    this.http.get<SceneCommentDto[]>("http://localhost:8080/admin/sceneComment").subscribe(resultData => {
      this.sceneCommentsSubject.next(resultData);
    });
  }

  saveSceneComment(newSceneComment: SceneCommentDto): void {
    this.http.post<SceneCommentDto>("http://localhost:8080/admin/sceneComment", newSceneComment).subscribe(() => {
      this.listSceneComments();
    });
  }

  deleteSceneComment(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/sceneComment/${id}`);
  }

  updateSceneComment(updatedSceneComment: SceneCommentDto): void {
    this.http.put<SceneCommentDto>("http://localhost:8080/admin/sceneComment", updatedSceneComment).subscribe(() => {
      this.listSceneComments();
    });
  }
}
