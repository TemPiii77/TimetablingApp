import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {ClassSubjectDto} from "../dto/class-subject-dto";
import {ClassSubjectIdDto} from "../dto/class-subject-id-dto";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class ClassSubjectService {

  private classSubjectsSubject = new BehaviorSubject<ClassSubjectDto[]>([]);
  classSubjects$ = this.classSubjectsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listClassSubjects(): void {
    this.http.get<ClassSubjectDto[]>("http://localhost:8080/admin/classSubject", {headers: this.authService.headers}).subscribe(resultData => {
      this.classSubjectsSubject.next(resultData);
    });
  }

  saveClassSubject(newClassSubjectId: ClassSubjectIdDto): void {
    this.http.post<ClassSubjectIdDto>("http://localhost:8080/admin/classSubject", newClassSubjectId, {headers: this.authService.headers}).subscribe(() => {
      this.listClassSubjects();
    });
  }

  deleteClassSubject(classId: number, subjectId: number ): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/classSubject/${classId}_${subjectId}`, {headers: this.authService.headers});
  }

  updateClassSubject(updatedClassSubjectId: ClassSubjectIdDto): void {
    this.http.put<ClassSubjectIdDto>("http://localhost:8080/admin/classSubject", updatedClassSubjectId, {headers: this.authService.headers}).subscribe(() => {
      this.listClassSubjects();
    });
  }
}
