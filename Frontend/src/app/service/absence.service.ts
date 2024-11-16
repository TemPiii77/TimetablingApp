import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {AbsenceDto} from "../dto/absence-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class AbsenceService {

  private absencesSubject = new BehaviorSubject<AbsenceDto[]>([]);
  absences$ = this.absencesSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listAbsences(): void {
    this.http.get<AbsenceDto[]>("http://localhost:8080/admin/absence", {headers: this.authService.headers}).subscribe(resultData => {
      this.absencesSubject.next(resultData);
    });
  }

  saveAbsence(newAbsence: AbsenceDto): void {
    this.http.post<AbsenceDto>("http://localhost:8080/admin/absence", newAbsence, {headers: this.authService.headers}).subscribe(() => {
      this.listAbsences();
    });
  }

  deleteAbsence(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/absence/${id}`, {headers: this.authService.headers});
  }

  updateAbsence(updatedAbsence: AbsenceDto): void {
    this.http.put<AbsenceDto>("http://localhost:8080/admin/absence", updatedAbsence, {headers: this.authService.headers}).subscribe(() => {
      this.listAbsences();
    });
  }
}
