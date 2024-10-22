import { Component } from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SubjectDto} from "../../dto/subject-dto";
import {SubjectService} from "../../service/subject.service";

@Component({
  selector: 'app-subject',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './subject.component.html',
  styleUrl: './subject.component.css'
})
export class SubjectComponent {
  subjects: SubjectDto[] = [];
  defaultSubject: SubjectDto | undefined;

  subjectForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('')
  })

  constructor(private subjectService: SubjectService) {}

  ngOnInit(): void {
    this.subjectService.listSubjects();

    this.subjectService.subjects$.subscribe(resultData => {
      this.subjects = resultData;
    });
  }

  saveSubject(newSubject: SubjectDto): void {
    this.subjectService.saveSubject(newSubject)
    this.subjectService.listSubjects();
  }

  deleteSubject(id: number): void {
    this.subjectService.deleteSubject(id).subscribe(() => {
      this.subjectService.listSubjects();
    });
  }

  updateSubject(updatedSubject: SubjectDto): void {
    this.subjectService.updateSubject(updatedSubject)
    this.subjectService.listSubjects();
  }

  handleSubmit(event: any) {
    const subject = {
      id: this.subjectForm.value.id ? Number(this.subjectForm.value.id) : 0,
      name: this.subjectForm.value.name!,
    };

    if(event.submitter.name == "save") {
      this.subjectForm.get('id')?.setValue(null);
      subject.id = 0;
      this.saveSubject(subject);
    }
    else if(event.submitter.name == "update") {
      this.updateSubject(subject);
      this.subjectForm.get('id')?.setValue(null);
    }
  }

  updateSubjectForm(subject: SubjectDto) {
    this.defaultSubject = subject;

    this.subjectForm.patchValue({
      id: this.defaultSubject.id!.toString(),
      name: this.defaultSubject.name
    });
  }
}
