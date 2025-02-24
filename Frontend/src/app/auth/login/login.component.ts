import { Component } from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "../../service/auth.service";
import {UserDto} from "../../dto/user-dto";
import {MatButtonToggle, MatButtonToggleModule} from "@angular/material/button-toggle";
import {MatButton, MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatOptionModule} from "@angular/material/core";
import {MatSelectModule} from "@angular/material/select";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {MatRadioButton} from "@angular/material/radio";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatInputModule,
    MatOptionModule,
    MatSelectModule,
    MatSlideToggleModule,
    FormsModule,
    MatRadioButton,
    MatButtonToggle,
    MatButton,
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
