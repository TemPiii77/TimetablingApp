import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {DelayDto} from "../dto/delay-dto";

@Injectable({
  providedIn: 'root'
})
export class DelayService {

  private delaysSubject = new BehaviorSubject<DelayDto[]>([]);
  delays$ = this.delaysSubject.asObservable();

  constructor(private http: HttpClient) {}

  listDelays(): void {
    this.http.get<DelayDto[]>("http://localhost:8080/admin/delay").subscribe(resultData => {
      this.delaysSubject.next(resultData);
    });
  }

  saveDelay(newDelay: DelayDto): void {
    this.http.post<DelayDto>("http://localhost:8080/admin/delay", newDelay).subscribe(() => {
      this.listDelays();
    });
  }

  deleteDelay(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/delay/${id}`);
  }

  updateDelay(updatedDelay: DelayDto): void {
    this.http.put<DelayDto>("http://localhost:8080/admin/delay", updatedDelay).subscribe(() => {
      this.listDelays();
    });
  }
}
