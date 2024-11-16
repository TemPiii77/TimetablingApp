import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {TimeslotDto} from "../dto/timeslot-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class TimeslotService {

  private timeslotsSubject = new BehaviorSubject<TimeslotDto[]>([]);
  timeslots$ = this.timeslotsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listTimeslots(): void {
    this.http.get<TimeslotDto[]>("http://localhost:8080/admin/timeslot", {headers: this.authService.headers}).subscribe(resultData => {
      this.timeslotsSubject.next(resultData);
    });
  }

  saveTimeslot(newTimeslotDto: TimeslotDto): void {
    this.http.post<TimeslotDto>("http://localhost:8080/admin/timeslot", newTimeslotDto, {headers: this.authService.headers}).subscribe(() => {
      this.listTimeslots();
    });
  }

  deleteTimeslot(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/timeslot/${id}`, {headers: this.authService.headers});
  }

  updateTimeslot(updatedTimeslotDto: TimeslotDto): void {
    this.http.put<TimeslotDto>("http://localhost:8080/admin/timeslot", updatedTimeslotDto, {headers: this.authService.headers}).subscribe(() => {
      this.listTimeslots();
    });
  }
}
