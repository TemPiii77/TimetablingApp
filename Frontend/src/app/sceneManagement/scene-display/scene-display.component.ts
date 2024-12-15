import {Component, OnInit} from '@angular/core';
import {SceneDto} from "../../dto/scene-dto";
import {SubjectDto} from "../../dto/subject-dto";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {SceneService} from "../../service/scene.service";
import {SubjectService} from "../../service/subject.service";
import {Router} from "@angular/router";
import {ClassDto} from "../../dto/class-dto";
import {ClassService} from "../../service/class.service";
import {AuthService} from "../../service/auth.service";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-scene-display',
  standalone: true,
  imports: [
    NgForOf,
    ReactiveFormsModule
  ],
  templateUrl: './scene-display.component.html',
  styleUrl: './scene-display.component.css'
})
export class SceneDisplayComponent implements OnInit{

  classes: ClassDto[] = [];
  scenes: SceneDto[] = [];

  constructor(private classService: ClassService,
              private sceneService: SceneService,
              private authService: AuthService,
              private router: Router) {}

  ngOnInit(): void {
    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.classService.listStudentsClasses(user);
      this.sceneService.listUsersScenes(user, Number(new Date().getFullYear()));
    });

    this.classService.classes$.subscribe(resultData => {
      this.classes = resultData;
    });

    this.sceneService.scenes$.subscribe(resultData => {
      this.scenes = resultData;
    });
  }

  handleSubmit(event: Event) {

    const selectedYear = (event.target as HTMLSelectElement).value;

    // @ts-ignore
    this.authService.currentUser.subscribe(user => {
      this.sceneService.listUsersScenes(user, Number(selectedYear));
    });

    this.sceneService.scenes$.subscribe(resultData => {
      this.scenes = resultData;
    });
  }

  navigateTo(id: number) {
    this.router.navigate([`/forum/${id}`]);
  }
}
