import {Component, OnInit} from '@angular/core';
import {ScenePartService} from "../../service/scene-part.service";
import {SceneCommentService} from "../../service/scene-comment.service";
import {UserService} from "../../service/user.service";
import {ClassService} from "../../service/class.service";
import {ClassDto} from "../../dto/class-dto";
import {AuthService} from "../../service/auth.service";
import {CommonModule, DatePipe, NgForOf} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AbsenceDto} from "../../dto/absence-dto";
import {AbsenceService} from "../../service/absence.service";
import {SubjectService} from "../../service/subject.service";
import {SubjectDto} from "../../dto/subject-dto";
import {GradeDto} from "../../dto/grade-dto";
import {GradeService} from "../../service/grade.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-grade',
  standalone: true,
  imports: [
    DatePipe,
    FormsModule,
    NgForOf,
    CommonModule
  ],
  templateUrl: './grade.component.html',
  styleUrl: './grade.component.css'
})
export class GradeComponent implements OnInit{

  grades: GradeDto[] = [];
  selectedClassId: Number | undefined;
  subjectId: Number | undefined;
  mean: number | undefined;

  constructor(private gradeService: GradeService,
              private authService: AuthService,
              private router: Router,
              private route: ActivatedRoute) {}

  ngOnInit(): void {

    this.route.paramMap.subscribe((params) => {
      this.selectedClassId = Number(params.get('selectedClassId'));
      this.subjectId = Number(params.get('subjectId'));
    });

    console.log(this.selectedClassId + " " + this.subjectId)

    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.gradeService.listStudentsGrades(user, this.selectedClassId!, this.subjectId!);
    });

    this.gradeService.grades$.subscribe(resultData => {
      this.grades = resultData;

      this.calculateMean();
    });



  }

  getTimestampInMilliseconds(dateRecorded: Date | undefined): number {
    return Number(dateRecorded) * 1000;
  }

  calculateMean() {

    let sum = 0;
    let count = 0;

    for(let i = 0; i < this.grades.length; i++) {
      switch (this.grades[i].type) {
        case "Témazáró":
          sum += this.grades[i].value * 2;
          count += 2;
          break;
        case "Vizsga":
          sum += this.grades[i].value * 3;
          count += 3;
          break;
        default:
          sum += this.grades[i].value;
          count++;
      }
    }

    this.mean = sum/count;
  }

}
