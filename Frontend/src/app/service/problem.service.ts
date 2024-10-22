import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ProblemDto} from "../dto/problem-dto";

@Injectable({
  providedIn: 'root'
})
export class ProblemService {

  private problemsSubject = new BehaviorSubject<ProblemDto[]>([]);
  problems$ = this.problemsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listProblems(): void {
    this.http.get<ProblemDto[]>("http://localhost:8080/admin/problem").subscribe(resultData => {
      this.problemsSubject.next(resultData);
    });
  }

  saveProblem(newProblem: ProblemDto): void {
    this.http.post<ProblemDto>("http://localhost:8080/admin/problem", newProblem).subscribe(() => {
      this.listProblems();
    });
  }

  deleteProblem(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/problem/${id}`);
  }

  updateProblem(updatedProblem: ProblemDto): void {
    this.http.put<ProblemDto>("http://localhost:8080/admin/problem", updatedProblem).subscribe(() => {
      this.listProblems();
    });
  }
}
