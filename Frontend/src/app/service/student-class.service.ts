import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {StudentClassDto} from "../dto/student-class-dto";
import {StudentClassIdDto} from "../dto/student-class-id-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class StudentClassService {

  private studentClassesSubject = new BehaviorSubject<StudentClassDto[]>([]);
  studentClasses$ = this.studentClassesSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listStudentClasses(): void {
    this.http.get<StudentClassDto[]>("http://localhost:8080/admin/studentClass", {headers: this.authService.headers}).subscribe(resultData => {
      this.studentClassesSubject.next(resultData);
    });
  }

  saveStudentClass(newStudentClassId: StudentClassIdDto): void {
    this.http.post<StudentClassIdDto>("http://localhost:8080/admin/studentClass", newStudentClassId, {headers: this.authService.headers}).subscribe(() => {
      this.listStudentClasses();
    });
  }

  deleteStudentClass(studentId: string, classId: number ): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/studentClass/${studentId}_${classId}`, {headers: this.authService.headers});
  }

  updateStudentClass(updatedStudentClassId: StudentClassIdDto): void {
    this.http.put<StudentClassIdDto>("http://localhost:8080/admin/studentClass", updatedStudentClassId, {headers: this.authService.headers}).subscribe(() => {
      this.listStudentClasses();
    });
  }
}
