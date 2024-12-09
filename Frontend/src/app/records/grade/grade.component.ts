import {Component, OnInit} from '@angular/core';
import {ScenePartService} from "../../service/scene-part.service";
import {SceneCommentService} from "../../service/scene-comment.service";
import {UserService} from "../../service/user.service";
import {ClassService} from "../../service/class.service";
import {ClassDto} from "../../dto/class-dto";
import {AuthService} from "../../service/auth.service";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-grade',
  standalone: true,
  imports: [
    DatePipe
  ],
  templateUrl: './grade.component.html',
  styleUrl: './grade.component.css'
})
export class GradeComponent {

}
