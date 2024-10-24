import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {TeacherDto} from "../../dto/teacher-dto";
import {TeacherService} from "../../service/teacher.service";
import {UserDto} from "../../dto/user-dto";

@Component({
  selector: 'app-teacher',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './teacher.component.html',
  styleUrl: './teacher.component.css'
})
export class TeacherComponent implements OnInit{

  teachers: TeacherDto[] = [];
  defaultTeacher: TeacherDto | undefined;

  teacherForm = new FormGroup({
    id: new FormControl(''),
    user: new FormControl(<UserDto | null>null),
    jobTitle: new FormControl(''),
  })

  constructor(private teacherService: TeacherService) {}

  ngOnInit(): void {
    this.teacherService.listTeachers();

    this.teacherService.teachers$.subscribe(resultData => {
      this.teachers = resultData;
    });
  }

  updateTeacher(updatedTeacher: TeacherDto): void {
    this.teacherService.updateTeacher(updatedTeacher)
    this.teacherService.listTeachers();
  }

  handleSubmit(event: any) {
    const teacher = {
      id: this.teacherForm.value.id!,
      user: this.teacherForm.value.user!,
      jobTitle: this.teacherForm.value.jobTitle!,
    };


      this.updateTeacher(teacher);
      this.teacherForm.get('id')?.setValue(null);
      this.teacherForm.get('user')?.setValue(null);
      this.teacherForm.get('jobTitle')?.setValue(null);

  }

  updateTeacherForm(teacher: TeacherDto) {
    this.defaultTeacher = teacher;

    this.teacherForm.patchValue({
      id: this.defaultTeacher.id!,
      user: this.defaultTeacher.user,
      jobTitle: this.defaultTeacher.jobTitle,
    });
  }

}
