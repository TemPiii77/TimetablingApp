import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ScenePartDto} from "../dto/scene-part-dto";

@Injectable({
  providedIn: 'root'
})
export class ScenePartService {

  private scenePartsSubject = new BehaviorSubject<ScenePartDto[]>([]);
  sceneParts$ = this.scenePartsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listSceneParts(): void {
    this.http.get<ScenePartDto[]>("http://localhost:8080/admin/scenePart").subscribe(resultData => {
      this.scenePartsSubject.next(resultData);
    });
  }

  saveScenePart(newScenePart: ScenePartDto): void {
    this.http.post<ScenePartDto>("http://localhost:8080/admin/scenePart", newScenePart).subscribe(() => {
      this.listSceneParts();
    });
  }

  deleteScenePart(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/scenePart/${id}`);
  }

  updateScenePart(updatedScenePart: ScenePartDto): void {
    this.http.put<ScenePartDto>("http://localhost:8080/admin/scenePart", updatedScenePart).subscribe(() => {
      this.listSceneParts();
    });
  }
}
