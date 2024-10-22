import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {TeacherPreferredTimeDto} from "../dto/teacher-preferred-time-dto";
import {TeacherPreferredTimeIdDto} from "../dto/teacher-preferred-time-id-dto";

@Injectable({
  providedIn: 'root'
})
export class TeacherPreferredTimeService {

  private teacherPreferredTimesSubject = new BehaviorSubject<TeacherPreferredTimeDto[]>([]);
  teacherPreferredTimes$ = this.teacherPreferredTimesSubject.asObservable();

  constructor(private http: HttpClient) {}

  listTeacherPreferredTimes(): void {
    this.http.get<TeacherPreferredTimeDto[]>("http://localhost:8080/admin/teacherPreferredTime").subscribe(resultData => {
      this.teacherPreferredTimesSubject.next(resultData);
    });
  }

  saveTeacherPreferredTime(newTeacherPreferredTimeId: TeacherPreferredTimeIdDto): void {
    this.http.post<TeacherPreferredTimeIdDto>("http://localhost:8080/admin/teacherPreferredTime", newTeacherPreferredTimeId).subscribe(() => {
      this.listTeacherPreferredTimes();
    });
  }

  deleteTeacherPreferredTime(teacherId: string, preferredTimeId: number ): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/teacherPreferredTime/${teacherId}_${preferredTimeId}`);
  }

  updateTeacherPreferredTime(updatedTeacherPreferredTimeId: TeacherPreferredTimeIdDto): void {
    this.http.put<TeacherPreferredTimeIdDto>("http://localhost:8080/admin/teacherPreferredTime", updatedTeacherPreferredTimeId).subscribe(() => {
      this.listTeacherPreferredTimes();
    });
  }
}
