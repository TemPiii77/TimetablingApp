import { Component } from '@angular/core';
import {UserComponent} from "../user/user.component";
import {StudentComponent} from "../student/student.component";
import {AdminComponent} from "../admin/admin.component";
import {TeacherComponent} from "../teacher/teacher.component";

@Component({
  selector: 'app-user-container',
  standalone: true,
  imports: [
    UserComponent,
    StudentComponent,
    AdminComponent,
    TeacherComponent
  ],
  templateUrl: './user-container.component.html',
  styleUrl: './user-container.component.css'
})
export class UserContainerComponent {

}
