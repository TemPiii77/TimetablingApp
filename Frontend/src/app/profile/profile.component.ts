import {Component, OnInit} from '@angular/core';
import {AuthService} from "../service/auth.service";
import {UserDto} from "../dto/user-dto";
import {ClassroomService} from "../service/classroom.service";
import {Observable} from "rxjs";
import {AsyncPipe, CommonModule} from "@angular/common";

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [
    AsyncPipe,
    CommonModule
  ],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent{

  constructor(protected authService: AuthService) {}

}
