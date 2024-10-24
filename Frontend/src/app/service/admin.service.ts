import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {AdminDto} from "../dto/admin-dto";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private adminsSubject = new BehaviorSubject<AdminDto[]>([]);
  admins$ = this.adminsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listAdmins(): void {
    this.http.get<AdminDto[]>("http://localhost:8080/admin/admin").subscribe(resultData => {
      this.adminsSubject.next(resultData);
    });
  }
}
