import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {TeacherSubjectDto} from "../dto/teacher-subject-dto";
import {TeacherSubjectIdDto} from "../dto/teacher-subject-id-dto";

@Injectable({
  providedIn: 'root'
})
export class TeacherSubjectService {

  private teacherSubjectsSubject = new BehaviorSubject<TeacherSubjectDto[]>([]);
  teacherSubjects$ = this.teacherSubjectsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listTeacherSubjects(): void {
    this.http.get<TeacherSubjectDto[]>("http://localhost:8080/admin/teacherSubject").subscribe(resultData => {
      this.teacherSubjectsSubject.next(resultData);
    });
  }

  saveTeacherSubject(newTeacherSubjectId: TeacherSubjectIdDto): void {
    this.http.post<TeacherSubjectIdDto>("http://localhost:8080/admin/teacherSubject", newTeacherSubjectId).subscribe(() => {
      this.listTeacherSubjects();
    });
  }

  deleteTeacherSubject(teacherId: string, subjectId: number ): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/teacherSubject/${teacherId}_${subjectId}`);
  }

  updateTeacherSubject(updatedTeacherSubjectId: TeacherSubjectIdDto): void {
    this.http.put<TeacherSubjectIdDto>("http://localhost:8080/admin/teacherSubject", updatedTeacherSubjectId).subscribe(() => {
      this.listTeacherSubjects();
    });
  }
}
