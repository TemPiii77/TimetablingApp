import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {SubjectDto} from "../dto/subject-dto";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {UserDto} from "../dto/user-dto";
import {AbsenceDto} from "../dto/absence-dto";

@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  private subjectsSubject = new BehaviorSubject<SubjectDto[]>([]);
  subjects$ = this.subjectsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listSubjects(): void {
    this.http.get<SubjectDto[]>("http://localhost:8080/admin/subject", {headers: this.authService.headers}).subscribe(resultData => {
      this.subjectsSubject.next(resultData);
    });
  }

  listStudentsSubjects(classId: number): void {
    this.http.post<SubjectDto[]>("http://localhost:8080/student/studentsSubjects", classId,  {headers: this.authService.headers}).subscribe(resultData => {
      this.subjectsSubject.next(resultData);
    });
  }

  saveSubject(newSubject: SubjectDto): void {
    this.http.post<SubjectDto>("http://localhost:8080/admin/subject", newSubject, {headers: this.authService.headers}).subscribe(() => {
      this.listSubjects();
    });
  }

  deleteSubject(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/subject/${id}`, {headers: this.authService.headers});
  }

  updateSubject(updatedSubject: SubjectDto): void {
    this.http.put<SubjectDto>("http://localhost:8080/admin/subject", updatedSubject, {headers: this.authService.headers}).subscribe(() => {
      this.listSubjects();
    });
  }

}
