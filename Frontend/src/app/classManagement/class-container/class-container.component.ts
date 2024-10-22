import { Component } from '@angular/core';
import {ClassComponent} from "../class/class.component";
import {ClassSubjectComponent} from "../class-subject/class-subject.component";
import {StudentClassComponent} from "../student-class/student-class.component";

@Component({
  selector: 'app-class-container',
  standalone: true,
  imports: [
    ClassComponent,
    ClassSubjectComponent,
    StudentClassComponent
  ],
  templateUrl: './class-container.component.html',
  styleUrl: './class-container.component.css'
})
export class ClassContainerComponent {

}
