import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {ProblemDto} from "../dto/problem-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class ProblemService {

  private problemsSubject = new BehaviorSubject<ProblemDto[]>([]);
  problems$ = this.problemsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listProblems(): void {
    this.http.get<ProblemDto[]>("http://localhost:8080/admin/problem", {headers: this.authService.headers}).subscribe(resultData => {
      this.problemsSubject.next(resultData);
    });
  }

  saveProblem(newProblem: ProblemDto): void {
    this.http.post<ProblemDto>("http://localhost:8080/admin/problem", newProblem, {headers: this.authService.headers}).subscribe(() => {
      this.listProblems();
    });
  }

  deleteProblem(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/problem/${id}`, {headers: this.authService.headers});
  }

  updateProblem(updatedProblem: ProblemDto): void {
    this.http.put<ProblemDto>("http://localhost:8080/admin/problem", updatedProblem, {headers: this.authService.headers}).subscribe(() => {
      this.listProblems();
    });
  }
}
