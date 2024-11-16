import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {SubjectSubjectRequirementDto} from "../dto/subject-subject-requirement-dto";
import {SubjectSubjectRequirementIdDto} from "../dto/subject-subject-requirement-id-dto";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class SubjectSubjectRequirementService {

  private subjectSubjectRequirementsSubject = new BehaviorSubject<SubjectSubjectRequirementDto[]>([]);
  subjectSubjectRequirements$ = this.subjectSubjectRequirementsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listSubjectSubjectRequirements(): void {
    this.http.get<SubjectSubjectRequirementDto[]>("http://localhost:8080/admin/subjectSubjectRequirement", {headers: this.authService.headers}).subscribe(resultData => {
      this.subjectSubjectRequirementsSubject.next(resultData);
    });
  }

  saveSubjectSubjectRequirement(newSubjectSubjectRequirementId: SubjectSubjectRequirementIdDto): void {
    this.http.post<SubjectSubjectRequirementIdDto>("http://localhost:8080/admin/subjectSubjectRequirement", newSubjectSubjectRequirementId, {headers: this.authService.headers}).subscribe(() => {
      this.listSubjectSubjectRequirements();
    });
  }

  deleteSubjectSubjectRequirement(subjectId: number, subjectRequirementId: number ): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/subjectSubjectRequirement/${subjectId}_${subjectRequirementId}`, {headers: this.authService.headers});
  }

  updateSubjectSubjectRequirement(updatedSubjectSubjectRequirementId: SubjectSubjectRequirementIdDto): void {
    this.http.put<SubjectSubjectRequirementIdDto>("http://localhost:8080/admin/subjectSubjectRequirement", updatedSubjectSubjectRequirementId, {headers: this.authService.headers}).subscribe(() => {
      this.listSubjectSubjectRequirements();
    });
  }
}
