import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {CookieService} from "ngx-cookie-service";
import {UserDto} from "../dto/user-dto";
import {Router} from "@angular/router";
import {catchError, Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  currentUser: Observable<UserDto> | undefined;
  token: string = "";
  headers = new HttpHeaders();

  constructor(private http: HttpClient,
              private cookieService: CookieService,
              private router: Router) { }

  login(user: UserDto): void {
    this.http.post("http://localhost:8080/login", user, { responseType: 'text' })
      .pipe(
        catchError(error => {
          if (error.status === 401) {
            alert("Nem megfelelő bejelentkezési adatok!");
          } else {
            alert("Hiba történt!");
          }
          return of(null);
        })
      )
      .subscribe((resultData) => {
        if (resultData) {
          localStorage.setItem('token', resultData);
          this.cookieService.set('token', resultData);
          this.token = this.cookieService.get('token');
          console.log(this.token);
          this.headers = new HttpHeaders({
            'Authorization': this.token ? `Bearer ${this.token}` : ''
          });
          this.currentUser = this.userInformation(this.token);
          this.router.navigate(['/home']);
        }
      });
  }

  logout(): void {
    this.cookieService.delete('token');
    this.token = '';
    this.currentUser = undefined;
    this.headers = new HttpHeaders();
    this.router.navigate(['/login']);
  }

  userInformation(token: string): Observable<UserDto> {
    return this.http.post<UserDto>("http://localhost:8080/userInformation", token, {headers: this.headers});
  }

  isAuthenticated(): boolean {
    const token = this.cookieService.get('token');
    return !!token;
  }

}
