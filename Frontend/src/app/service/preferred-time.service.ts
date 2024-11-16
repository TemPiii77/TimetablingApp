import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {PreferredTimeDto} from "../dto/preferred-time-dto";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class PreferredTimeService {

  private preferredTimesSubject = new BehaviorSubject<PreferredTimeDto[]>([]);
  preferredTimes$ = this.preferredTimesSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listPreferredTimes(): void {
    this.http.get<PreferredTimeDto[]>("http://localhost:8080/admin/preferredTime", {headers: this.authService.headers}).subscribe(resultData => {
      this.preferredTimesSubject.next(resultData);
    });
  }

  savePreferredTime(newPreferredTime: PreferredTimeDto): void {
    this.http.post<PreferredTimeDto>("http://localhost:8080/admin/preferredTime", newPreferredTime, {headers: this.authService.headers}).subscribe(() => {
      this.listPreferredTimes();
    });
  }

  deletePreferredTime(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/preferredTime/${id}`, {headers: this.authService.headers});
  }

  updatePreferredTime(updatedPreferredTime: PreferredTimeDto): void {
    this.http.put<PreferredTimeDto>("http://localhost:8080/admin/preferredTime", updatedPreferredTime, {headers: this.authService.headers}).subscribe(() => {
      this.listPreferredTimes();
    });
  }
}
