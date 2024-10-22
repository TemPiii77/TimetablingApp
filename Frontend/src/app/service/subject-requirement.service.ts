import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {SubjectRequirementDto} from "../dto/subject-requirement-dto";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SubjectRequirementService {

  private subjectRequirementsSubject = new BehaviorSubject<SubjectRequirementDto[]>([]);
  subjectRequirements$ = this.subjectRequirementsSubject.asObservable();

  constructor(private http: HttpClient) {}

  listSubjectRequirements(): void {
    this.http.get<SubjectRequirementDto[]>("http://localhost:8080/admin/subjectRequirement").subscribe(resultData => {
      this.subjectRequirementsSubject.next(resultData);
    });
  }


  saveSubjectRequirement(newSubjectRequirement: SubjectRequirementDto): void {
    this.http.post<SubjectRequirementDto>("http://localhost:8080/admin/subjectRequirement", newSubjectRequirement).subscribe(() => {
      this.listSubjectRequirements();
    });
  }

  deleteSubjectRequirement(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/subjectRequirement/${id}`);
  }

  updateSubjectRequirement(updatedSubjectRequirement: SubjectRequirementDto): void {
    this.http.put<SubjectRequirementDto>("http://localhost:8080/admin/subjectRequirement", updatedSubjectRequirement).subscribe(() => {
      this.listSubjectRequirements();
    });
  }
}
