import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {ClassSubjectDto} from "../dto/class-subject-dto";
import {ClassSubjectIdDto} from "../dto/class-subject-id-dto";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ClassSubjectService {

  private classSubjectsSubject = new BehaviorSubject<ClassSubjectDto[]>([]);
  classSubjects$ = this.classSubjectsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listClassSubjects(): void {
    this.http.get<ClassSubjectDto[]>("http://localhost:8080/admin/classSubject").subscribe(resultData => {
      this.classSubjectsSubject.next(resultData);
    });
  }

  saveClassSubject(newClassSubjectId: ClassSubjectIdDto): void {
    this.http.post<ClassSubjectIdDto>("http://localhost:8080/admin/classSubject", newClassSubjectId).subscribe(() => {
      this.listClassSubjects();
    });
  }

  deleteClassSubject(classId: number, subjectId: number ): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/classSubject/${classId}_${subjectId}`);
  }

  updateClassSubject(updatedClassSubjectId: ClassSubjectIdDto): void {
    this.http.put<ClassSubjectIdDto>("http://localhost:8080/admin/classSubject", updatedClassSubjectId).subscribe(() => {
      this.listClassSubjects();
    });
  }
}
