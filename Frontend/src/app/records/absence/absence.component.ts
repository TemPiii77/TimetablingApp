import {Component, OnInit} from '@angular/core';
import {ClassDto} from "../../dto/class-dto";
import {ClassService} from "../../service/class.service";
import {AuthService} from "../../service/auth.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AbsenceService} from "../../service/absence.service";
import {CommonModule, DatePipe} from "@angular/common";
import {AbsenceDto} from "../../dto/absence-dto";
import {BrowserModule} from "@angular/platform-browser";

@Component({
  selector: 'app-absence',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    DatePipe,
    CommonModule
  ],
  templateUrl: './absence.component.html',
  styleUrl: './absence.component.css'
})
export class AbsenceComponent implements OnInit{

  classes: ClassDto[] = [];
  absences: AbsenceDto[] = [];

  constructor(private classService: ClassService,
              private absenceService: AbsenceService,
              private authService: AuthService) {}

  ngOnInit(): void {
    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.classService.listStudentsClasses(user);
      this.absenceService.listStudentsAbsences(user, Number(new Date().getFullYear()));
    });

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;
    });

    this.absenceService.absences$.subscribe(resultData => {
      this.absences = resultData;
    });
  }

  handleSubmit(event: Event) {

    const selectedYear = (event.target as HTMLSelectElement).value;

    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.absenceService.listStudentsAbsences(user, Number(selectedYear));
    });

    this.absenceService.absences$.subscribe(resultData => {
      this.absences = resultData;
    });
  }

  getTimestampInMilliseconds(dateRecorded: Date | undefined): number {
    return Number(dateRecorded) * 1000;
  }
}
