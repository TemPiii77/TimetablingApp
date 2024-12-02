import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {SceneCommentDto} from "../dto/scene-comment-dto";
import {AuthService} from "./auth.service";
import {CookieService} from "ngx-cookie-service";

@Injectable({
  providedIn: 'root'
})
export class SceneCommentService {

  private sceneCommentsSubject = new BehaviorSubject<SceneCommentDto[]>([]);
  sceneComments$ = this.sceneCommentsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listSceneComments(): void {
    this.http.get<SceneCommentDto[]>("http://localhost:8080/admin/sceneComment", {headers: this.authService.headers}).subscribe(resultData => {
      this.sceneCommentsSubject.next(resultData);
    });
  }

  listSceneComment(id: Number): void {
    this.http.get<SceneCommentDto[]>(`http://localhost:8080/admin/sceneComment/${id}`, {headers: new HttpHeaders({'Authorization': localStorage.getItem('token') ? `Bearer ${localStorage.getItem('token')}` : '' })}).subscribe(resultData => {
      this.sceneCommentsSubject.next(resultData);
    });
  }

  saveSceneComment(newSceneComment: SceneCommentDto): void {
    this.http.post<SceneCommentDto>("http://localhost:8080/admin/sceneComment", newSceneComment, {headers: new HttpHeaders({'Authorization': localStorage.getItem('token') ? `Bearer ${localStorage.getItem('token')}` : '' })}).subscribe(() => {
      this.listSceneComments();
    });
  }

  deleteSceneComment(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/sceneComment/${id}`, {headers: this.authService.headers});
  }

  updateSceneComment(updatedSceneComment: SceneCommentDto): void {
    this.http.put<SceneCommentDto>("http://localhost:8080/admin/sceneComment", updatedSceneComment, {headers: this.authService.headers}).subscribe(() => {
      this.listSceneComments();
    });
  }
}
