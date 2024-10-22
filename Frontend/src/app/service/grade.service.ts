import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {GradeDto} from "../dto/grade-dto";

@Injectable({
  providedIn: 'root'
})
export class GradeService {

  private gradesSubject = new BehaviorSubject<GradeDto[]>([]);
  grades = this.gradesSubject.asObservable();

  constructor(private http: HttpClient) {}

  listGrades(): void {
    this.http.get<GradeDto[]>("http://localhost:8080/admin/grade").subscribe(resultData => {
      this.gradesSubject.next(resultData);
    });
  }

  saveGrade(newGrade: GradeDto): void {
    this.http.post<GradeDto>("http://localhost:8080/admin/grade", newGrade).subscribe(() => {
      this.listGrades();
    });
  }

  deleteGrade(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/grade/${id}`);
  }

  updateGrade(updatedGrade: GradeDto): void {
    this.http.put<GradeDto>("http://localhost:8080/admin/grade", updatedGrade).subscribe(() => {
      this.listGrades();
    });
  }
}
