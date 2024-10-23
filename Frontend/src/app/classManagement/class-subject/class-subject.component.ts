import {Component, OnInit} from '@angular/core';
import {SubjectSubjectRequirementDto} from "../../dto/subject-subject-requirement-dto";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {SubjectSubjectRequirementService} from "../../service/subject-subject-requirement.service";
import {SubjectSubjectRequirementIdDto} from "../../dto/subject-subject-requirement-id-dto";
import {ClassDto} from "../../dto/class-dto";
import {ClassService} from "../../service/class.service";
import {ClassSubjectDto} from "../../dto/class-subject-dto";
import {ClassSubjectIdDto} from "../../dto/class-subject-id-dto";
import {ClassSubjectService} from "../../service/class-subject.service";
import {SubjectDto} from "../../dto/subject-dto";
import {SubjectService} from "../../service/subject.service";

@Component({
  selector: 'app-class-subject',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './class-subject.component.html',
  styleUrl: './class-subject.component.css'
})
export class ClassSubjectComponent implements OnInit {

  classSubjects: ClassSubjectDto[] = [];
  classes: ClassDto[] = [];
  subjects: SubjectDto[] = [];
  subjectSubjectRequirements: SubjectSubjectRequirementDto[] = [];

  classSubjectForm = new FormGroup({
    classId: new FormControl(''),
    subjectId: new FormControl(''),
  })

  constructor(private classSubjectService: ClassSubjectService,
              private classService: ClassService,
              private subjectService: SubjectService,
              private subjectSubjectRequirementService: SubjectSubjectRequirementService) {}

  ngOnInit(): void {
    this.classSubjectService.listClassSubjects();
    this.classService.listClasses();
    this.subjectService.listSubjects();
    this.subjectSubjectRequirementService.listSubjectSubjectRequirements();

    this.classSubjectService.classSubjects$.subscribe(resultData => {
      this.classSubjects = resultData;
    });

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;
    });

    this.subjectService.subjects$.subscribe(resultData => {
      this.subjects = resultData;
    });

    this.subjectSubjectRequirementService.subjectSubjectRequirements$.subscribe(resultData => {
      this.subjectSubjectRequirements = resultData;
    });
  }

  saveclassSubject(newSubjectSubjectRequirementId: ClassSubjectIdDto): void {
    this.classSubjectService.saveClassSubject(newSubjectSubjectRequirementId)
    this.classSubjectService.listClassSubjects();
  }

  deleteclassSubject(classId: number, subjectId: number): void {
    this.classSubjectService.deleteClassSubject(classId, subjectId).subscribe(() => {
      this.classSubjectService.listClassSubjects();
    });
  }

  updateclassSubject(updatedSubjectSubjectRequirementId: ClassSubjectIdDto): void {
    this.classSubjectService.updateClassSubject(updatedSubjectSubjectRequirementId)
    this.classSubjectService.listClassSubjects();
  }

  handleSubmit(event: any) {
    const classSubject = {
      classId: this.classSubjectForm.value.classId ? Number(this.classSubjectForm.value.classId) : 0,
      subjectId: this.classSubjectForm.value.subjectId ? Number(this.classSubjectForm.value.subjectId) : 0
    };

    if(event.submitter.name == "save") {
      this.saveclassSubject(classSubject);
    }
    else if(event.submitter.name == "update") {
      this.updateclassSubject(classSubject);
    }
  }

  formatFields(subjectRequirement: any): string {
    return Object.values(subjectRequirement).join(' - ');
  }


}
