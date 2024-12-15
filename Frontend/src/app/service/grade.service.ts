import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {GradeDto} from "../dto/grade-dto";
import {AuthService} from "./auth.service";
import {UserDto} from "../dto/user-dto";
import {AbsenceDto} from "../dto/absence-dto";

@Injectable({
  providedIn: 'root'
})
export class GradeService {

  private gradesSubject = new BehaviorSubject<GradeDto[]>([]);
  grades$ = this.gradesSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listGrades(): void {
    this.http.get<GradeDto[]>("http://localhost:8080/admin/grade", {headers: this.authService.headers}).subscribe(resultData => {
      this.gradesSubject.next(resultData);
    });
  }

  listStudentsGrades(user: UserDto, classId: Number, subjectId: Number): void {
    this.http.post<GradeDto[]>(`http://localhost:8080/student/studentsGrades/${classId}/${subjectId}`, user,  {headers: this.authService.headers}).subscribe(resultData => {
      this.gradesSubject.next(resultData);
    });
  }

  saveGrade(newGrade: GradeDto): void {
    this.http.post<GradeDto>("http://localhost:8080/admin/grade", newGrade, {headers: this.authService.headers}).subscribe(() => {
      this.listGrades();
    });
  }

  deleteGrade(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/grade/${id}`, {headers: this.authService.headers});
  }

  updateGrade(updatedGrade: GradeDto): void {
    this.http.put<GradeDto>("http://localhost:8080/admin/grade", updatedGrade, {headers: this.authService.headers}).subscribe(() => {
      this.listGrades();
    });
  }
}
