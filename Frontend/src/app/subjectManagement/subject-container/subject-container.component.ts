import { Component } from '@angular/core';
import {SubjectComponent} from "../subject/subject.component";
import {SubjectRequirementComponent} from "../subject-requirement/subject-requirement.component";
import {SubjectSubjectRequirementComponent} from "../subject-subject-requirement/subject-subject-requirement.component";
import {TeacherSubjectComponent} from "../teacher-subject/teacher-subject.component";

@Component({
  selector: 'app-subject-container',
  standalone: true,
  imports: [
    SubjectComponent,
    SubjectRequirementComponent,
    SubjectSubjectRequirementComponent,
    TeacherSubjectComponent
  ],
  templateUrl: './subject-container.component.html',
  styleUrl: './subject-container.component.css'
})
export class SubjectContainerComponent {

}
