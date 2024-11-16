import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {DelayDto} from "../dto/delay-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class DelayService {

  private delaysSubject = new BehaviorSubject<DelayDto[]>([]);
  delays$ = this.delaysSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listDelays(): void {
    this.http.get<DelayDto[]>("http://localhost:8080/admin/delay", {headers: this.authService.headers}).subscribe(resultData => {
      this.delaysSubject.next(resultData);
    });
  }

  saveDelay(newDelay: DelayDto): void {
    this.http.post<DelayDto>("http://localhost:8080/admin/delay", newDelay, {headers: this.authService.headers}).subscribe(() => {
      this.listDelays();
    });
  }

  deleteDelay(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/delay/${id}`, {headers: this.authService.headers});
  }

  updateDelay(updatedDelay: DelayDto): void {
    this.http.put<DelayDto>("http://localhost:8080/admin/delay", updatedDelay, {headers: this.authService.headers}).subscribe(() => {
      this.listDelays();
    });
  }
}
