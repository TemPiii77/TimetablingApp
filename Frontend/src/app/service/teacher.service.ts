import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {TeacherDto} from "../dto/teacher-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  private teachersSubject = new BehaviorSubject<TeacherDto[]>([]);
  teachers$ = this.teachersSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listTeachers(): void {
    this.http.get<TeacherDto[]>("http://localhost:8080/admin/teacher", {headers: this.authService.headers}).subscribe(resultData => {
      this.teachersSubject.next(resultData);
    });
  }

  updateTeacher(updatedTeacher: TeacherDto): void {
    this.http.put<TeacherDto>("http://localhost:8080/admin/teacher", updatedTeacher, {headers: this.authService.headers}).subscribe(() => {
      this.listTeachers();
    });
  }
}
