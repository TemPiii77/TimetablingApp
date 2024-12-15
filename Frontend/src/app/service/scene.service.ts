import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {SceneDto} from "../dto/scene-dto";
import {AuthService} from "./auth.service";
import {UserDto} from "../dto/user-dto";
import {AbsenceDto} from "../dto/absence-dto";

@Injectable({
  providedIn: 'root'
})
export class SceneService {

  private scenesSubject = new BehaviorSubject<SceneDto[]>([]);
  scenes$ = this.scenesSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listScenes(): void {
    this.http.get<SceneDto[]>("http://localhost:8080/admin/scene", {headers: this.authService.headers}).subscribe(resultData => {
      this.scenesSubject.next(resultData);
    });
  }

  listUsersScenes(user: UserDto, year: number): void {
    this.http.post<SceneDto[]>(`http://localhost:8080/usersScenes/${year}`, user,  {headers: this.authService.headers}).subscribe(resultData => {
      this.scenesSubject.next(resultData);
    });
  }

  saveScene(newScene: SceneDto): void {
    this.http.post<SceneDto>("http://localhost:8080/admin/scene", newScene, {headers: this.authService.headers}).subscribe(() => {
      this.listScenes();
    });
  }

  deleteScene(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/scene/${id}`, {headers: this.authService.headers});
  }

  updateScene(updatedScene: SceneDto): void {
    this.http.put<SceneDto>("http://localhost:8080/admin/scene", updatedScene, {headers: this.authService.headers}).subscribe(() => {
      this.listScenes();
    });
  }
}
