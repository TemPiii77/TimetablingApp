import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SubjectDto} from "../../dto/subject-dto";
import {SubjectService} from "../../service/subject.service";
import {TeacherDto} from "../../dto/teacher-dto";
import {TeacherService} from "../../service/teacher.service";
import {TeacherSubjectDto} from "../../dto/teacher-subject-dto";
import {TeacherSubjectIdDto} from "../../dto/teacher-subject-id-dto";
import {TeacherSubjectService} from "../../service/teacher-subject.service";

@Component({
  selector: 'app-teacher-subject',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './teacher-subject.component.html',
  styleUrl: './teacher-subject.component.css'
})
export class TeacherSubjectComponent implements OnInit{

  teacherSubjects: TeacherSubjectDto[] = [];
  subjects: SubjectDto[] = [];
  teachers: TeacherDto[] = [];

  teacherSubjectIdForm = new FormGroup({
    teacherId: new FormControl(''),
    subjectId: new FormControl(''),
  })

  constructor(private teacherSubjectService: TeacherSubjectService,
              private subjectService: SubjectService,
              private teacherService: TeacherService) {}

  ngOnInit(): void {
    this.teacherSubjectService.listTeacherSubjects();
    this.subjectService.listSubjects();
    this.teacherService.listTeachers();

    this.teacherSubjectService.teacherSubjects$.subscribe(resultData => {
      this.teacherSubjects = resultData;
    });

    this.subjectService.subjects$.subscribe(resultData => {
      this.subjects = resultData;
    });

    this.teacherService.teachers$.subscribe(resultData => {
      this.teachers = resultData;
    });
  }

  saveTeacherSubject(newTeacherSubjectId: TeacherSubjectIdDto): void {
    this.teacherSubjectService.saveTeacherSubject(newTeacherSubjectId)
    this.teacherSubjectService.listTeacherSubjects();
  }

  deleteTeacherSubject(teacherId: string, subjectId: number): void {
    this.teacherSubjectService.deleteTeacherSubject(teacherId, subjectId).subscribe(() => {
      this.teacherSubjectService.listTeacherSubjects();
    });
  }

  updateTeacherSubject(updatedTeacherSubjectId: TeacherSubjectIdDto): void {
    this.teacherSubjectService.updateTeacherSubject(updatedTeacherSubjectId)
    this.teacherSubjectService.listTeacherSubjects();
  }

  handleSubmit(event: any) {
    const teacherSubjectId = {
      teacherId: this.teacherSubjectIdForm.value.teacherId!,
      subjectId: this.teacherSubjectIdForm.value.subjectId ? Number(this.teacherSubjectIdForm.value.subjectId) : 0
    };

    if(event.submitter.name == "save") {
      this.saveTeacherSubject(teacherSubjectId);
    }
    else if(event.submitter.name == "update") {
      this.saveTeacherSubject(teacherSubjectId);
    }
  }

  formatFields(fields: any): string {
    return Object.values(fields).join(' - ');
  }

}
