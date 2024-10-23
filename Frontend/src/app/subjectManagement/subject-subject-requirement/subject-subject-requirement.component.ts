import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {SubjectSubjectRequirementDto} from "../../dto/subject-subject-requirement-dto";
import {SubjectSubjectRequirementIdDto} from "../../dto/subject-subject-requirement-id-dto";
import {SubjectSubjectRequirementService} from "../../service/subject-subject-requirement.service";
import {SubjectDto} from "../../dto/subject-dto";
import {SubjectRequirementDto} from "../../dto/subject-requirement-dto";
import {SubjectService} from "../../service/subject.service";
import {SubjectRequirementService} from "../../service/subject-requirement.service";

@Component({
  selector: 'app-subject-subject-requirement',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './subject-subject-requirement.component.html',
  styleUrl: './subject-subject-requirement.component.css'
})
export class SubjectSubjectRequirementComponent implements OnInit {

  subjectSubjectRequirements: SubjectSubjectRequirementDto[] = [];
  subjects: SubjectDto[] = [];
  subjectRequirements: SubjectRequirementDto[] = [];

  subjectSubjectRequirementForm = new FormGroup({
    subject: new FormControl(''),
    subjectRequirement: new FormControl(''),
  })

  constructor(private subjectSubjectRequirementService: SubjectSubjectRequirementService,
              private subjectService: SubjectService,
              private subjectRequirementService: SubjectRequirementService) {}

  ngOnInit(): void {
    this.subjectSubjectRequirementService.listSubjectSubjectRequirements();
    this.subjectRequirementService.listSubjectRequirements();
    this.subjectService.listSubjects();

    this.subjectSubjectRequirementService.subjectSubjectRequirements$.subscribe(resultData => {
      this.subjectSubjectRequirements = resultData;
    });

    this.subjectRequirementService.subjectRequirements$.subscribe(resultData => {
      this.subjectRequirements = resultData;
    });

    this.subjectService.subjects$.subscribe(resultData => {
      this.subjects = resultData;
    });
  }

  saveSubjectSubjectRequirement(newSubjectSubjectRequirementId: SubjectSubjectRequirementIdDto): void {
    this.subjectSubjectRequirementService.saveSubjectSubjectRequirement(newSubjectSubjectRequirementId)
    this.subjectSubjectRequirementService.listSubjectSubjectRequirements();
  }

  deleteSubjectSubjectRequirement(subjectId: number, subjectRequirementId: number): void {
    this.subjectSubjectRequirementService.deleteSubjectSubjectRequirement(subjectId, subjectRequirementId).subscribe(() => {
      this.subjectSubjectRequirementService.listSubjectSubjectRequirements();
    });
  }

  updateSubjectSubjectRequirement(updatedSubjectSubjectRequirementId: SubjectSubjectRequirementIdDto): void {
    this.subjectSubjectRequirementService.updateSubjectSubjectRequirement(updatedSubjectSubjectRequirementId)
    this.subjectSubjectRequirementService.listSubjectSubjectRequirements();
  }

  handleSubmit(event: any) {
    const subjectSubjectRequirementId = {
      subjectId: this.subjectSubjectRequirementForm.value.subject ? Number(this.subjectSubjectRequirementForm.value.subject) : 0,
      subjectRequirementId: this.subjectSubjectRequirementForm.value.subjectRequirement ? Number(this.subjectSubjectRequirementForm.value.subjectRequirement) : 0
    };

    if(event.submitter.name == "save") {
      this.saveSubjectSubjectRequirement(subjectSubjectRequirementId);
    }
    else if(event.submitter.name == "update") {
      this.updateSubjectSubjectRequirement(subjectSubjectRequirementId);
    }
  }

  formatFields(subjectRequirement: any): string {
    return Object.values(subjectRequirement).join(' - ');
  }

}
