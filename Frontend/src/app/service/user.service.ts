import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {UserDto} from "../dto/user-dto";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersSubject = new BehaviorSubject<UserDto[]>([]);
  users$ = this.usersSubject.asObservable();

  constructor(private http: HttpClient) {}

  listUsers(): void {
    this.http.get<UserDto[]>("http://localhost:8080/admin/user").subscribe(resultData => {
      this.usersSubject.next(resultData);
    });
  }

  saveUser(newUser: UserDto, roleBasedInformation: string): void {
    this.http.post<UserDto>(`http://localhost:8080/admin/register?name=${roleBasedInformation}`, newUser).subscribe(() => {
      this.listUsers();
    });
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/user/${id}`);
  }

  updateUser(updatedUser: UserDto, roleBasedInformation: string): void {
    this.http.put<UserDto>(`http://localhost:8080/admin/user?name=${roleBasedInformation}`, updatedUser).subscribe(() => {
      this.listUsers();
    });
  }
}
