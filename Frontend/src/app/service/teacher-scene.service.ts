import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {TeacherSceneDto} from "../dto/teacher-scene-dto";
import {TeacherSceneIdDto} from "../dto/teacher-scene-id-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class TeacherSceneService {

  private teacherScenesSubject = new BehaviorSubject<TeacherSceneDto[]>([]);
  teacherScenes$ = this.teacherScenesSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listTeacherScenes(): void {
    this.http.get<TeacherSceneDto[]>("http://localhost:8080/admin/teacherScene", {headers: this.authService.headers}).subscribe(resultData => {
      this.teacherScenesSubject.next(resultData);
    });
  }

  saveTeacherScene(newTeacherSceneId: TeacherSceneIdDto): void {
    this.http.post<TeacherSceneIdDto>("http://localhost:8080/admin/teacherScene", newTeacherSceneId, {headers: this.authService.headers}).subscribe(() => {
      this.listTeacherScenes();
    });
  }

  deleteTeacherScene(teacherId: string, sceneId: number ): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/teacherScene/${teacherId}_${sceneId}`, {headers: this.authService.headers});
  }

  updateTeacherScene(updatedTeacherSceneId: TeacherSceneIdDto): void {
    this.http.put<TeacherSceneIdDto>("http://localhost:8080/admin/teacherScene", updatedTeacherSceneId, {headers: this.authService.headers}).subscribe(() => {
      this.listTeacherScenes();
    });
  }
}
