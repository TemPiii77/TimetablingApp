import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SubjectRequirementDto} from "../../dto/subject-requirement-dto";
import {SubjectRequirementService} from "../../service/subject-requirement.service";
import {NgForOf} from "@angular/common";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-subject-requirement',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NgForOf,
    CommonModule
  ],
  templateUrl: './subject-requirement.component.html',
  styleUrl: './subject-requirement.component.css'
})
export class SubjectRequirementComponent implements OnInit {

  subjectRequirements: SubjectRequirementDto[] = [];
  defaultSubjectRequirement: SubjectRequirementDto | undefined;

  fields = ["Általános", "Informatika", "Angol"];

  subjectRequirementForm = new FormGroup({
    id: new FormControl(''),
    field: new FormControl(''),
    grade: new FormControl(<number | null>null),
    period: new FormControl(<number | null>null),
    advanced: new FormControl(<boolean | null>null),
  })

  constructor(private subjectRequirementService: SubjectRequirementService) {}

  ngOnInit(): void {
    this.subjectRequirementService.listSubjectRequirements();

    this.subjectRequirementService.subjectRequirements$.subscribe(resultData => {
      this.subjectRequirements = resultData;
    });
  }

  saveSubjectRequirement(newClassroom: SubjectRequirementDto): void {
    this.subjectRequirementService.saveSubjectRequirement(newClassroom)
    this.subjectRequirementService.listSubjectRequirements();
  }

  deleteSubjectRequirement(id: number): void {
    this.subjectRequirementService.deleteSubjectRequirement(id).subscribe(() => {
      this.subjectRequirementService.listSubjectRequirements();
    });
  }

  updateSubjectRequirement(updatedClassroom: SubjectRequirementDto): void {
    this.subjectRequirementService.updateSubjectRequirement(updatedClassroom)
    this.subjectRequirementService.listSubjectRequirements();
  }

  handleSubmit(event: any) {
    const subjectRequirement = {
      id: this.subjectRequirementForm.value.id ? Number(this.subjectRequirementForm.value.id) : 0,
      field: this.subjectRequirementForm.value.field!,
      grade: this.subjectRequirementForm.value.grade!,
      period: this.subjectRequirementForm.value.period!,
      advanced: this.subjectRequirementForm.value.advanced!
    };

    if(event.submitter.name == "save") {
      this.subjectRequirementForm.get('id')?.setValue(null);
      subjectRequirement.id = 0;
      this.saveSubjectRequirement(subjectRequirement);
    }
    else if(event.submitter.name == "update") {
      this.updateSubjectRequirement(subjectRequirement);
      this.subjectRequirementForm.get('id')?.setValue(null);
    }
  }

  updateSubjectRequirementForm(subjectRequirement: SubjectRequirementDto) {
    this.defaultSubjectRequirement = subjectRequirement;

    this.subjectRequirementForm.patchValue({
      id: this.defaultSubjectRequirement.id!.toString(),
      field: this.defaultSubjectRequirement.field,
      grade: this.defaultSubjectRequirement.grade,
      period: this.defaultSubjectRequirement.period,
      advanced: this.defaultSubjectRequirement.advanced
    });
  }

}
