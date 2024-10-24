import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {TeacherPreferredTimeDto} from "../../dto/teacher-preferred-time-dto";
import {TeacherPreferredTimeIdDto} from "../../dto/teacher-preferred-time-id-dto";
import {TeacherPreferredTimeService} from "../../service/teacher-preferred-time.service";
import {TeacherDto} from "../../dto/teacher-dto";
import {TeacherService} from "../../service/teacher.service";
import {PreferredTimeDto} from "../../dto/preferred-time-dto";
import {PreferredTimeService} from "../../service/preferred-time.service";

@Component({
  selector: 'app-teacher-preferred-time',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './teacher-preferred-time.component.html',
  styleUrl: './teacher-preferred-time.component.css'
})
export class TeacherPreferredTimeComponent implements OnInit{

  teacherPreferredTimes: TeacherPreferredTimeDto[] = [];
  teachers: TeacherDto[] = [];
  preferredTimes: PreferredTimeDto[] = [];

  teacherPreferredTimeForm = new FormGroup({
    teacherId: new FormControl(''),
    preferredTimeId: new FormControl(''),
  })

  constructor(private teacherPreferredTimeService: TeacherPreferredTimeService,
              private teacherService: TeacherService,
              private preferredTimeService: PreferredTimeService) {}

  ngOnInit(): void {
    this.teacherPreferredTimeService.listTeacherPreferredTimes();
    this.teacherService.listTeachers();
    this.preferredTimeService.listPreferredTimes();

    this.teacherPreferredTimeService.teacherPreferredTimes$.subscribe(resultData => {
      this.teacherPreferredTimes = resultData;
    });

    this.teacherService.teachers$.subscribe(resultData => {
      this.teachers = resultData;
    });

    this.preferredTimeService.preferredTimes$.subscribe(resultData => {
      this.preferredTimes = resultData;
    });
  }

  saveTeacherPreferredTime(newTeacherPreferredTimeId: TeacherPreferredTimeIdDto): void {
    this.teacherPreferredTimeService.saveTeacherPreferredTime(newTeacherPreferredTimeId)
    this.teacherPreferredTimeService.listTeacherPreferredTimes();
  }

  deleteTeacherPreferredTime(teacherId: string, preferredTimeId: number): void {
    this.teacherPreferredTimeService.deleteTeacherPreferredTime(teacherId, preferredTimeId).subscribe(() => {
      this.teacherPreferredTimeService.listTeacherPreferredTimes();
    });
  }

  updateTeacherPreferredTime(updatedTeacherPreferredTimeId: TeacherPreferredTimeIdDto): void {
    this.teacherPreferredTimeService.updateTeacherPreferredTime(updatedTeacherPreferredTimeId)
    this.teacherPreferredTimeService.listTeacherPreferredTimes();
  }

  handleSubmit(event: any) {
    const teacherPreferredTimeId = {
      teacherId: this.teacherPreferredTimeForm.value.teacherId!,
      preferredTimeId: this.teacherPreferredTimeForm.value.preferredTimeId ? Number(this.teacherPreferredTimeForm.value.preferredTimeId) : 0
    };

    if(event.submitter.name == "save") {
      this.saveTeacherPreferredTime(teacherPreferredTimeId);
    }
    else if(event.submitter.name == "update") {
      this.updateTeacherPreferredTime(teacherPreferredTimeId);
    }
  }

  formatFields(fields: any): string {
    return Object.values(fields).join(' - ');
  }

}
