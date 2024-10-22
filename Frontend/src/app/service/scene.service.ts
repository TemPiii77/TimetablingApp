import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {SceneDto} from "../dto/scene-dto";

@Injectable({
  providedIn: 'root'
})
export class SceneService {

  private scenesSubject = new BehaviorSubject<SceneDto[]>([]);
  scenes$ = this.scenesSubject.asObservable();

  constructor(private http: HttpClient) {}

  listScenes(): void {
    this.http.get<SceneDto[]>("http://localhost:8080/admin/scene").subscribe(resultData => {
      this.scenesSubject.next(resultData);
    });
  }

  saveScene(newScene: SceneDto): void {
    this.http.post<SceneDto>("http://localhost:8080/admin/scene", newScene).subscribe(() => {
      this.listScenes();
    });
  }

  deleteScene(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/scene/${id}`);
  }

  updateScene(updatedScene: SceneDto): void {
    this.http.put<SceneDto>("http://localhost:8080/admin/scene", updatedScene).subscribe(() => {
      this.listScenes();
    });
  }
}
