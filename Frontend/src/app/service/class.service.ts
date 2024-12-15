import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {ClassDto} from "../dto/class-dto";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {UserDto} from "../dto/user-dto";

@Injectable({
  providedIn: 'root'
})
export class ClassService {

  private classesSubject = new BehaviorSubject<ClassDto[]>([]);
  classes$ = this.classesSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listClasses(): void {
    this.http.get<ClassDto[]>("http://localhost:8080/admin/class", {headers: this.authService.headers}).subscribe(resultData => {
      this.classesSubject.next(resultData);
    });
  }

  listStudentsClasses(user: UserDto): void {
    this.http.post<ClassDto[]>("http://localhost:8080/usersClasses", user, {headers: this.authService.headers}).subscribe(resultData => {
      this.classesSubject.next(resultData);
    });
  }

  saveClass(newClass: ClassDto): void {
    this.http.post<ClassDto>("http://localhost:8080/admin/class", newClass, {headers: this.authService.headers}).subscribe(() => {
      this.listClasses();
    });
  }

  deleteClass(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/class/${id}`, {headers: this.authService.headers});
  }

  updateClass(updatedClass: ClassDto): void {
    this.http.put<ClassDto>("http://localhost:8080/admin/class", updatedClass, {headers: this.authService.headers}).subscribe(() => {
      this.listClasses();
    });
  }
}
