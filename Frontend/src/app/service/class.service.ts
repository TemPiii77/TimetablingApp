import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {ClassDto} from "../dto/class-dto";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ClassService {

  private classesSubject = new BehaviorSubject<ClassDto[]>([]);
  classes$ = this.classesSubject.asObservable();

  constructor(private http: HttpClient) {}

  listClasses(): void {
    this.http.get<ClassDto[]>("http://localhost:8080/admin/class").subscribe(resultData => {
      this.classesSubject.next(resultData);
    });
  }

  saveClass(newClass: ClassDto): void {
    this.http.post<ClassDto>("http://localhost:8080/admin/class", newClass).subscribe(() => {
      this.listClasses();
    });
  }

  deleteClass(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/class/${id}`);
  }

  updateClass(updatedClass: ClassDto): void {
    this.http.put<ClassDto>("http://localhost:8080/admin/class", updatedClass).subscribe(() => {
      this.listClasses();
    });
  }
}
