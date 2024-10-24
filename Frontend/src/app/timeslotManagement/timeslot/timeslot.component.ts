import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ClassDto} from "../../dto/class-dto";
import {ClassService} from "../../service/class.service";
import {TeacherDto} from "../../dto/teacher-dto";
import {TeacherService} from "../../service/teacher.service";
import {SubjectDto} from "../../dto/subject-dto";
import {SubjectSubjectRequirementDto} from "../../dto/subject-subject-requirement-dto";
import {SubjectSubjectRequirementService} from "../../service/subject-subject-requirement.service";
import {ClassroomDto} from "../../dto/classroom-dto";
import {ClassroomService} from "../../service/classroom.service";
import {TimeslotDto} from "../../dto/timeslot-dto";
import {TimeslotService} from "../../service/timeslot.service";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-timeslot',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NgForOf
  ],
  templateUrl: './timeslot.component.html',
  styleUrl: './timeslot.component.css'
})
export class TimeslotComponent implements OnInit{

  timeslots: TimeslotDto[] = [];
  defaultTimeslot: TimeslotDto | undefined;
  classes: ClassDto[] = [];
  teachers: TeacherDto[] = [];
  subjectSubjectRequirements: SubjectSubjectRequirementDto[] = [];
  classrooms: ClassroomDto[] = [];

  days = ["Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek"]

  timeslotForm = new FormGroup({
    id: new FormControl(''),
    year: new FormControl(<number | null>null),
    day: new FormControl(''),
    hour: new FormControl(<number | null>null),
    classField: new FormControl(<ClassDto | null>null),
    teacher: new FormControl(<TeacherDto | null>null),
    subject: new FormControl(<SubjectDto | null>null),
    classroom: new FormControl(<ClassroomDto | null>null)
  })

  constructor(private timeslotService: TimeslotService,
              private classService: ClassService,
              private teacherService: TeacherService,
              private subjectSubjectRequirementService: SubjectSubjectRequirementService,
              private classroomService: ClassroomService,
              ) {}

  ngOnInit(): void {
    this.timeslotService.listTimeslots();
    this.classService.listClasses();
    this.teacherService.listTeachers();
    this.subjectSubjectRequirementService.listSubjectSubjectRequirements();
    this.classroomService.listClassrooms();

    this.timeslotService.timeslots$.subscribe(resultData => {
      this.timeslots = resultData;
    });

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;
    });

    this.teacherService.teachers$.subscribe(resultData => {
      this.teachers = resultData;
    });

    this.subjectSubjectRequirementService.subjectSubjectRequirements$.subscribe(resultData => {
      this.subjectSubjectRequirements = resultData;
    });

    this.classroomService.classrooms$.subscribe(resultData => {
      this.classrooms = resultData;
    });
  }

  saveTimeslot(newTimeslot: TimeslotDto): void {
    this.timeslotService.saveTimeslot(newTimeslot)
    this.timeslotService.listTimeslots();
  }

  deleteTimeslot(id: number): void {
    this.timeslotService.deleteTimeslot(id).subscribe(() => {
      this.timeslotService.listTimeslots();
    });
  }

  updateTimeslot(updatedTimeslot: TimeslotDto): void {
    this.timeslotService.updateTimeslot(updatedTimeslot)
    this.timeslotService.listTimeslots();
  }

  handleSubmit(event: any) {
    const timeslot = {
      id: this.timeslotForm.value.id ? Number(this.timeslotForm.value.id) : 0,
      year: this.timeslotForm.value.year!,
      day: this.timeslotForm.value.day!,
      hour: this.timeslotForm.value.hour!,
      classField: this.timeslotForm.value.classField!,
      teacher: this.timeslotForm.value.teacher!,
      subject: this.timeslotForm.value.subject!,
      classroom: this.timeslotForm.value.classroom!,
    };

    if(event.submitter.name == "save") {
      this.timeslotForm.get('id')?.setValue(null);
      timeslot.id = 0;
      this.saveTimeslot(timeslot);
    }
    else if(event.submitter.name == "update") {
      this.updateTimeslot(timeslot);
      this.timeslotForm.get('id')?.setValue(null);
    }
  }

  updateTimeslotForm(timeslot: TimeslotDto) {
    this.defaultTimeslot = timeslot;

    this.timeslotForm.patchValue({
      id: this.defaultTimeslot.id!.toString(),
      year: this.defaultTimeslot.year,
      day: this.defaultTimeslot.day,
      hour: this.defaultTimeslot.hour,
      classField: this.defaultTimeslot.classField,
      teacher: this.defaultTimeslot.teacher,
      subject: this.defaultTimeslot.subject,
      classroom: this.defaultTimeslot.classroom,
    });
  }

  formatFields(fields: any): string {
    return Object.values(fields).join(' - ');
  }

}
