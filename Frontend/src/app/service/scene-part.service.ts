import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ScenePartDto} from "../dto/scene-part-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class ScenePartService {

  private scenePartsSubject = new BehaviorSubject<ScenePartDto[]>([]);
  sceneParts$ = this.scenePartsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listSceneParts(): void {
    this.http.get<ScenePartDto[]>("http://localhost:8080/admin/scenePart", {headers: this.authService.headers}).subscribe(resultData => {
      this.scenePartsSubject.next(resultData);
    });
  }

  listScenePart(id: Number): void {
    this.http.get<ScenePartDto[]>(`http://localhost:8080/admin/scenePart/${id}`, {headers: this.authService.headers}).subscribe(resultData => {
      this.scenePartsSubject.next(resultData);
    });
  }

  saveScenePart(newScenePart: ScenePartDto): void {
    this.http.post<ScenePartDto>("http://localhost:8080/admin/scenePart", newScenePart, {headers: this.authService.headers}).subscribe(() => {
      this.listSceneParts();
    });
  }

  deleteScenePart(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/scenePart/${id}`, {headers: this.authService.headers});
  }

  updateScenePart(updatedScenePart: ScenePartDto): void {
    this.http.put<ScenePartDto>("http://localhost:8080/admin/scenePart", updatedScenePart, {headers: this.authService.headers}).subscribe(() => {
      this.listSceneParts();
    });
  }
}
