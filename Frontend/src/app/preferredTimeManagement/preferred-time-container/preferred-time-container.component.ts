import { Component } from '@angular/core';
import {PreferredTimeComponent} from "../preferred-time/preferred-time.component";
import {TeacherPreferredTimeComponent} from "../teacher-preferred-time/teacher-preferred-time.component";

@Component({
  selector: 'app-preferred-time-container',
  standalone: true,
  imports: [
    PreferredTimeComponent,
    TeacherPreferredTimeComponent
  ],
  templateUrl: './preferred-time-container.component.html',
  styleUrl: './preferred-time-container.component.css'
})
export class PreferredTimeContainerComponent {

}
