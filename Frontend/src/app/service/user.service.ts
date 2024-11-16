import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {UserDto} from "../dto/user-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersSubject = new BehaviorSubject<UserDto[]>([]);
  users$ = this.usersSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listUsers(): void {
    this.http.get<UserDto[]>("http://localhost:8080/admin/user", {headers: this.authService.headers}).subscribe(resultData => {
      this.usersSubject.next(resultData);
    });
  }

  saveUser(newUser: UserDto, roleBasedInformation: string): void {
    this.http.post<UserDto>(`http://localhost:8080/admin/register?name=${roleBasedInformation}`, newUser, {headers: this.authService.headers}).subscribe(() => {
      this.listUsers();
    });
  }

  deleteUser(id: string): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/user/${id}`, {headers: this.authService.headers});
  }

  updateUser(updatedUser: UserDto, roleBasedInformation: string): void {
    this.http.put<UserDto>(`http://localhost:8080/admin/user?name=${roleBasedInformation}`, updatedUser, {headers: this.authService.headers}).subscribe(() => {
      this.listUsers();
    });
  }
}
