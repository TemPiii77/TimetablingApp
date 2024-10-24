import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {StudentClassDto} from "../../dto/student-class-dto";
import {StudentClassIdDto} from "../../dto/student-class-id-dto";
import {StudentClassService} from "../../service/student-class.service";
import {StudentDto} from "../../dto/student-dto";
import {StudentService} from "../../service/student.service";
import {ClassDto} from "../../dto/class-dto";
import {ClassService} from "../../service/class.service";

@Component({
  selector: 'app-student-class',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './student-class.component.html',
  styleUrl: './student-class.component.css'
})
export class StudentClassComponent implements OnInit {

  studentClasses: StudentClassDto[] = [];
  students: StudentDto[] = [];
  classes: ClassDto[] = [];

  studentClassForm = new FormGroup({
    studentId: new FormControl(''),
    classId: new FormControl(''),
  })

  constructor(private studentClassService: StudentClassService,
              private studentService: StudentService,
              private classService: ClassService) {}

  ngOnInit(): void {
    this.studentClassService.listStudentClasses();
    this.studentService.listStudents();
    this.classService.listClasses();

    this.studentClassService.studentClasses$.subscribe(resultData => {
      this.studentClasses = resultData;
    });

    this.studentService.students$.subscribe(resultData => {
      this.students = resultData;
    });

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;
    });
  }

  saveStudentClass(newStudentClassId: StudentClassIdDto): void {
    this.studentClassService.saveStudentClass(newStudentClassId)
    this.studentClassService.listStudentClasses();
  }

  deleteStudentClass(studentId: string, classId: number): void {
    this.studentClassService.deleteStudentClass(studentId, classId).subscribe(() => {
      this.studentClassService.listStudentClasses();
    });
  }

  updateStudentClass(updatedStudentClassId: StudentClassIdDto): void {
    this.studentClassService.updateStudentClass(updatedStudentClassId)
    this.studentClassService.listStudentClasses();
  }

  handleSubmit(event: any) {
    const studentClassId = {
      studentId: this.studentClassForm.value.studentId!,
      classId: this.studentClassForm.value.classId ? Number(this.studentClassForm.value.classId) : 0
    };

    if(event.submitter.name == "save") {
      this.saveStudentClass(studentClassId);
    }
    else if(event.submitter.name == "update") {
      this.updateStudentClass(studentClassId);
    }
  }

  formatFields(fields: any): string {
    return Object.values(fields).join(' - ');
  }


}
