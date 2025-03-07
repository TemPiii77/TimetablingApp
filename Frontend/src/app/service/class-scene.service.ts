import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ClassSceneDto} from "../dto/class-scene-dto";
import {ClassSceneIdDto} from "../dto/class-scene-id-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class ClassSceneService {

  private classScenesSubject = new BehaviorSubject<ClassSceneDto[]>([]);
  classScenes$ = this.classScenesSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listClassScenes(): void {
    this.http.get<ClassSceneDto[]>("http://localhost:8080/admin/classScene", {headers: this.authService.headers}).subscribe(resultData => {
      this.classScenesSubject.next(resultData);
    });
  }

  saveClassScene(newClassSceneId: ClassSceneIdDto): void {
    this.http.post<ClassSceneIdDto>("http://localhost:8080/admin/classScene", newClassSceneId, {headers: this.authService.headers}).subscribe(() => {
      this.listClassScenes();
    });
  }

  deleteClassScene(classId: number, sceneId: number ): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/classScene/${classId}_${sceneId}`, {headers: this.authService.headers});
  }

  updateClassScene(updatedClassSceneId: ClassSceneIdDto): void {
    this.http.put<ClassSceneIdDto>("http://localhost:8080/admin/classScene", updatedClassSceneId, {headers: this.authService.headers}).subscribe(() => {
      this.listClassScenes();
    });
  }
}
