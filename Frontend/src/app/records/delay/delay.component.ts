import {Component, OnInit} from '@angular/core';
import {DatePipe, NgForOf} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {ClassDto} from "../../dto/class-dto";
import {AbsenceDto} from "../../dto/absence-dto";
import {ClassService} from "../../service/class.service";
import {AbsenceService} from "../../service/absence.service";
import {AuthService} from "../../service/auth.service";
import {DelayDto} from "../../dto/delay-dto";
import {DelayService} from "../../service/delay.service";

@Component({
  selector: 'app-delay',
  standalone: true,
  imports: [
    DatePipe,
    FormsModule,
    NgForOf
  ],
  templateUrl: './delay.component.html',
  styleUrl: './delay.component.css'
})
export class DelayComponent implements OnInit{

  classes: ClassDto[] = [];
  delays: DelayDto[] = [];

  constructor(private classService: ClassService,
              private delayService: DelayService,
              private authService: AuthService) {}

  ngOnInit(): void {
    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.classService.listStudentsClasses(user);
      this.delayService.listStudentsDelays(user, Number(new Date().getFullYear()));
    });

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;
    });

    this.delayService.delays$.subscribe(resultData => {
      this.delays = resultData;
    });
  }

  handleSubmit(event: Event) {

    const selectedYear = (event.target as HTMLSelectElement).value;

    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.delayService.listStudentsDelays(user, Number(selectedYear));
    });

    this.delayService.delays$.subscribe(resultData => {
      this.delays = resultData;
    });
  }

  getTimestampInMilliseconds(dateRecorded: Date | undefined): number {
    return Number(dateRecorded) * 1000;
  }

}
