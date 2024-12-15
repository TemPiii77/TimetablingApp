import {Component, OnInit} from '@angular/core';
import {DatePipe, NgForOf} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {ClassDto} from "../../dto/class-dto";
import {AbsenceDto} from "../../dto/absence-dto";
import {ClassService} from "../../service/class.service";
import {AbsenceService} from "../../service/absence.service";
import {AuthService} from "../../service/auth.service";
import {ProblemDto} from "../../dto/problem-dto";
import {ProblemService} from "../../service/problem.service";

@Component({
  selector: 'app-problem',
  standalone: true,
  imports: [
    DatePipe,
    FormsModule,
    NgForOf
  ],
  templateUrl: './problem.component.html',
  styleUrl: './problem.component.css'
})
export class ProblemComponent implements OnInit{

  classes: ClassDto[] = [];
  problems: ProblemDto[] = [];

  constructor(private classService: ClassService,
              private problemService: ProblemService,
              private authService: AuthService) {}

  ngOnInit(): void {
    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.classService.listStudentsClasses(user);
      this.problemService.listStudentsProblems(user, Number(new Date().getFullYear()));
    });

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;
    });

    this.problemService.problems$.subscribe(resultData => {
      this.problems = resultData;
    });
  }

  handleSubmit(event: Event) {

    const selectedYear = (event.target as HTMLSelectElement).value;

    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.problemService.listStudentsProblems(user, Number(selectedYear));
    });

    this.problemService.problems$.subscribe(resultData => {
      this.problems = resultData;
    });
  }

  getTimestampInMilliseconds(dateRecorded: Date | undefined): number {
    return Number(dateRecorded) * 1000;
  }

}
