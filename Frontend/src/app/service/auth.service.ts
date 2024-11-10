import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
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

  constructor(private http: HttpClient,
              private cookieSerivce: CookieService,
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
          this.cookieSerivce.set('token', resultData);
          this.token = this.cookieSerivce.get('token');
          console.log(this.token);
          this.currentUser = this.userInformation(this.token);

          this.router.navigate(['/home']);
        }
      });
  }

  userInformation(token: string): Observable<UserDto> {
    return this.http.post<UserDto>("http://localhost:8080/userInformation", token);
  }

  
}
