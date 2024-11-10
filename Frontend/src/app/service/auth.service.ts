import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CookieService} from "ngx-cookie-service";
import {UserDto} from "../dto/user-dto";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private token: string = "";

  constructor(private http: HttpClient,
              private cookieSerivce: CookieService,
              private router: Router) { }

  login(user: UserDto): void {
    this.http.post("http://localhost:8080/login", user, {responseType: 'text'}).subscribe((resultData) => {

      if(resultData == "fail") {
        alert("Nem megfelelő bejelentkezési adatok!")
      }
      else {
        this.cookieSerivce.set('token', resultData)
        this.token = this.cookieSerivce.get('token')
        console.log(this.token)
        this.userInformation(this.token);
        this.router.navigate(['/home'])
      }
    });
  }

  userInformation(token: string) {
    this.http.post("http://localhost:8080/userInformation", token, {responseType: 'text'}).subscribe((resultData) => {
      console.log(resultData)
    });
  }
}
