import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {TimeslotDto} from "../dto/timeslot-dto";

@Injectable({
  providedIn: 'root'
})
export class TimeslotService {

  private timeslotsSubject = new BehaviorSubject<TimeslotDto[]>([]);
  timeslots$ = this.timeslotsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listTimeslots(): void {
    this.http.get<TimeslotDto[]>("http://localhost:8080/admin/timeslot").subscribe(resultData => {
      this.timeslotsSubject.next(resultData);
    });
  }

  saveTimeslot(newTimeslotDto: TimeslotDto): void {
    this.http.post<TimeslotDto>("http://localhost:8080/admin/timeslot", newTimeslotDto).subscribe(() => {
      this.listTimeslots();
    });
  }

  deleteTimeslot(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/timeslot/${id}`);
  }

  updateTimeslot(updatedTimeslotDto: TimeslotDto): void {
    this.http.put<TimeslotDto>("http://localhost:8080/admin/timeslot", updatedTimeslotDto).subscribe(() => {
      this.listTimeslots();
    });
  }
}
