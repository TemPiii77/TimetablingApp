import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {SubjectDto} from "../dto/subject-dto";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  private subjectsSubject = new BehaviorSubject<SubjectDto[]>([]);
  subjects$ = this.subjectsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listSubjects(): void {
    this.http.get<SubjectDto[]>("http://localhost:8080/admin/subject").subscribe(resultData => {
      this.subjectsSubject.next(resultData);
    });
  }


  saveSubject(newSubject: SubjectDto): void {
    this.http.post<SubjectDto>("http://localhost:8080/admin/subject", newSubject).subscribe(() => {
      this.listSubjects();
    });
  }

  deleteSubject(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/subject/${id}`);
  }

  updateSubject(updatedSubject: SubjectDto): void {
    this.http.put<SubjectDto>("http://localhost:8080/admin/subject", updatedSubject).subscribe(() => {
      this.listSubjects();
    });
  }

}
