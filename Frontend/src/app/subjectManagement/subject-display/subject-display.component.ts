import {Component, OnInit} from '@angular/core';
import {ClassDto} from "../../dto/class-dto";
import {SubjectDto} from "../../dto/subject-dto";
import {ClassService} from "../../service/class.service";
import {SubjectService} from "../../service/subject.service";
import {AuthService} from "../../service/auth.service";
import {FormsModule} from "@angular/forms";
import {NgForOf} from "@angular/common";
import {Router} from "@angular/router";

@Component({
  selector: 'app-subject-display',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf
  ],
  templateUrl: './subject-display.component.html',
  styleUrl: './subject-display.component.css'
})
export class SubjectDisplayComponent implements OnInit{

  classes: ClassDto[] = [];
  subjects: SubjectDto[] = [];
  selectedClassId : number | undefined;

  constructor(private classService: ClassService,
              private subjectService: SubjectService,
              private authService: AuthService,
              private router: Router) {}

  ngOnInit(): void {
    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.classService.listStudentsClasses(user);
    });

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;

      if (this.classes && this.classes.length > 0) {
        this.selectedClassId = this.classes[0].id;
        this.subjectService.listStudentsSubjects(Number(this.selectedClassId));
      }
    });

    this.subjectService.subjects$.subscribe(resultData => {
      this.subjects = resultData;
    });
  }

  handleSubmit(event: Event) {

    this.selectedClassId = Number((event.target as HTMLSelectElement).value);

    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.subjectService.listStudentsSubjects(this.selectedClassId!);
    });

    this.subjectService.subjects$.subscribe(resultData => {
      this.subjects = resultData;
    });
  }

  navigateTo(subjectId: number) {
    this.router.navigate([`/subjects/${this.selectedClassId}/${subjectId}`]);
  }


}
