import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {SubjectSubjectRequirementDto} from "../dto/subject-subject-requirement-dto";
import {SubjectSubjectRequirementIdDto} from "../dto/subject-subject-requirement-id-dto";

@Injectable({
  providedIn: 'root'
})
export class SubjectSubjectRequirementService {

  private subjectSubjectRequirementsSubject = new BehaviorSubject<SubjectSubjectRequirementDto[]>([]);
  subjectSubjectRequirements$ = this.subjectSubjectRequirementsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listSubjectSubjectRequirements(): void {
    this.http.get<SubjectSubjectRequirementDto[]>("http://localhost:8080/admin/subjectSubjectRequirement").subscribe(resultData => {
      this.subjectSubjectRequirementsSubject.next(resultData);
    });
  }

  saveSubjectSubjectRequirement(newSubjectSubjectRequirementId: SubjectSubjectRequirementIdDto): void {
    this.http.post<SubjectSubjectRequirementIdDto>("http://localhost:8080/admin/subjectSubjectRequirement", newSubjectSubjectRequirementId).subscribe(() => {
      this.listSubjectSubjectRequirements();
    });
  }

  deleteSubjectSubjectRequirement(subjectId: number, subjectRequirementId: number ): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/subjectSubjectRequirement/${subjectId}_${subjectRequirementId}`);
  }

  updateSubjectSubjectRequirement(updatedSubjectSubjectRequirementId: SubjectSubjectRequirementIdDto): void {
    this.http.put<SubjectSubjectRequirementIdDto>("http://localhost:8080/admin/subjectSubjectRequirement", updatedSubjectSubjectRequirementId).subscribe(() => {
      this.listSubjectSubjectRequirements();
    });
  }
}
