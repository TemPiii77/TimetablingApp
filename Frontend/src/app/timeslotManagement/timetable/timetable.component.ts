import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {DatePipe, NgForOf} from "@angular/common";
import {ReactiveFormsModule} from "@angular/forms";
import {ClassDto} from "../../dto/class-dto";
import {AbsenceDto} from "../../dto/absence-dto";
import {ClassService} from "../../service/class.service";
import {AbsenceService} from "../../service/absence.service";
import {AuthService} from "../../service/auth.service";
import {TimeslotService} from "../../service/timeslot.service";
import {TimeslotDto} from "../../dto/timeslot-dto";

@Component({
  selector: 'app-timetable',
  standalone: true,
  imports: [
    DatePipe,
    NgForOf,
    ReactiveFormsModule
  ],
  templateUrl: './timetable.component.html',
  styleUrl: './timetable.component.css',
  encapsulation: ViewEncapsulation.ShadowDom
})
export class TimetableComponent implements OnInit{

  classes: ClassDto[] = [];
  timetable: TimeslotDto[] = [];
  daysOrder: string[] = ['Hétfő', 'Kedd', 'Szerda', 'Csütörtök', 'Péntek'];
  hours = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

  constructor(private classService: ClassService,
              private timeslotService: TimeslotService,
              private authService: AuthService) {}

  ngOnInit(): void {
    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.classService.listStudentsClasses(user);
      this.timeslotService.listStudentsTimeslots(user, Number(new Date().getFullYear()));
    });

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;
    });

    this.timeslotService.timeslots$.subscribe(resultData => {
      this.timetable = resultData;

      this.timetable.sort((a, b) => {
        const dayAIndex = this.daysOrder.indexOf(a.day);
        const dayBIndex = this.daysOrder.indexOf(b.day);
        if (dayAIndex !== dayBIndex) {
          return dayAIndex - dayBIndex;
        }
        return a.hour - b.hour;
      });

    });
  }

  handleSubmit(event: Event) {

    const selectedYear = (event.target as HTMLSelectElement).value;

    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.timeslotService.listStudentsTimeslots(user, Number(selectedYear));
    });

    this.timeslotService.timeslots$.subscribe(resultData => {
      this.timetable = resultData;
    });
  }

  getSubjectForDayAndHour(day: string, hour: number): string {
    const timeslot = this.timetable.find(
      (slot) => slot.day === day && slot.hour === hour
    );
    return timeslot ? `${timeslot.subject.name} <br> ${timeslot.classroom.name} terem` : '-';
  }

}
