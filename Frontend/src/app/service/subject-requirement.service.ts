import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {SubjectRequirementDto} from "../dto/subject-requirement-dto";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class SubjectRequirementService {

  private subjectRequirementsSubject = new BehaviorSubject<SubjectRequirementDto[]>([]);
  subjectRequirements$ = this.subjectRequirementsSubject.asObservable();

  constructor(private http: HttpClient,
              private authService: AuthService) {}

  listSubjectRequirements(): void {
    this.http.get<SubjectRequirementDto[]>("http://localhost:8080/admin/subjectRequirement", {headers: this.authService.headers}).subscribe(resultData => {
      this.subjectRequirementsSubject.next(resultData);
    });
  }


  saveSubjectRequirement(newSubjectRequirement: SubjectRequirementDto): void {
    this.http.post<SubjectRequirementDto>("http://localhost:8080/admin/subjectRequirement", newSubjectRequirement, {headers: this.authService.headers}).subscribe(() => {
      this.listSubjectRequirements();
    });
  }

  deleteSubjectRequirement(id: number): Observable<void> {
    return this.http.delete<void>(`http://localhost:8080/admin/subjectRequirement/${id}`, {headers: this.authService.headers});
  }

  updateSubjectRequirement(updatedSubjectRequirement: SubjectRequirementDto): void {
    this.http.put<SubjectRequirementDto>("http://localhost:8080/admin/subjectRequirement", updatedSubjectRequirement, {headers: this.authService.headers}).subscribe(() => {
      this.listSubjectRequirements();
    });
  }
}
