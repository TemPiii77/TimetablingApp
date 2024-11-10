import { Component } from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "../../service/auth.service";
import {UserDto} from "../../dto/user-dto";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginForm = new FormGroup({
    id: new FormControl(''),
    password: new FormControl('')
  })

  constructor(private authService: AuthService) {}

  login(user: UserDto): void {
    this.authService.login(user);
  }

  handleSubmit(event: any) {

    const user = {
      id: this.loginForm.value.id!,
      email: 'a',
      lastName: 'a',
      firstName: 'a',
      password: this.loginForm.value.password!,
      role: 'a',
    }

    console.log(user)
    this.login(user);
  }

}
