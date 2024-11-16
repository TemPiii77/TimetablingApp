import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {StudentDto} from "../dto/student-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private studentsSubject = new BehaviorSubject<StudentDto[]>([]);
  students$ = this.studentsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listStudents(): void {
    this.http.get<StudentDto[]>("http://localhost:8080/admin/student", {headers: this.authService.headers}).subscribe(resultData => {
      this.studentsSubject.next(resultData);
    });
  }

}
