import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {StudentDto} from "../../dto/student-dto";
import {StudentService} from "../../service/student.service";

@Component({
  selector: 'app-student',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './student.component.html',
  styleUrl: './student.component.css'
})
export class StudentComponent implements OnInit{

  students: StudentDto[] = [];

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.studentService.listStudents();

    this.studentService.students$.subscribe(resultData => {
      this.students = resultData;
    });
  }

}
