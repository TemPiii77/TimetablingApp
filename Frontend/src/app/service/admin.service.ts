import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {AdminDto} from "../dto/admin-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private adminsSubject = new BehaviorSubject<AdminDto[]>([]);
  admins$ = this.adminsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listAdmins(): void {
    this.http.get<AdminDto[]>("http://localhost:8080/admin/admin", {headers: this.authService.headers}).subscribe(resultData => {
      this.adminsSubject.next(resultData);
    });
  }
}
