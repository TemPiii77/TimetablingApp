import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ClassroomDto} from "../dto/classroom-dto";
import {BehaviorSubject, Observable} from "rxjs";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class ClassroomService {

  private classroomsSubject = new BehaviorSubject<ClassroomDto[]>([]);
  classrooms$ = this.classroomsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listClassrooms(): void {
    this.http.get<ClassroomDto[]>("http://localhost:8080/admin/classroom", {headers: this.authService.headers}).subscribe(resultData => {
      this.classroomsSubject.next(resultData);
    });
  }

  saveClassroom(newClassroom: ClassroomDto): void {
    this.http.post<ClassroomDto>("http://localhost:8080/admin/classroom", newClassroom, {headers: this.authService.headers}).subscribe(() => {
      this.listClassrooms();
    });
  }

  deleteClassroom(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/classroom/${id}`, {headers: this.authService.headers});
  }

  updateClassroom(updatedClassroom: ClassroomDto): void {
    this.http.put<ClassroomDto>("http://localhost:8080/admin/classroom", updatedClassroom, {headers: this.authService.headers}).subscribe(() => {
      this.listClassrooms();
    });
  }
}
