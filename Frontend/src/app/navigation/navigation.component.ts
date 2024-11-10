import { Component } from '@angular/core';
import {RouterLink} from "@angular/router";
import {AuthService} from "../service/auth.service";
import {AsyncPipe, CommonModule, NgIf} from "@angular/common";

@Component({
  selector: 'app-navigation',
  standalone: true,
  imports: [
    RouterLink,
    AsyncPipe,
    NgIf
  ],
  templateUrl: './navigation.component.html',
  styleUrl: './navigation.component.css'
})
export class NavigationComponent {

  constructor(protected authService: AuthService) {}


}
