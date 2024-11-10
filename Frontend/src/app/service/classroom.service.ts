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



    this.http.get<ClassroomDto[]>("http://localhost:8080/admin/classroom").subscribe(resultData => {
      this.classroomsSubject.next(resultData);
    });
  }

  saveClassroom(newClassroom: ClassroomDto): void {
    this.http.post<ClassroomDto>("http://localhost:8080/admin/classroom", newClassroom).subscribe(() => {
      this.listClassrooms();
    });
  }

  deleteClassroom(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/classroom/${id}`);
  }

  updateClassroom(updatedClassroom: ClassroomDto): void {
    this.http.put<ClassroomDto>("http://localhost:8080/admin/classroom", updatedClassroom).subscribe(() => {
      this.listClassrooms();
    });
  }
}
