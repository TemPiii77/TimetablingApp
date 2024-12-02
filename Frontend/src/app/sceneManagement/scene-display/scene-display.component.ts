import {Component, OnInit} from '@angular/core';
import {SceneDto} from "../../dto/scene-dto";
import {SubjectDto} from "../../dto/subject-dto";
import {FormControl, FormGroup} from "@angular/forms";
import {SceneService} from "../../service/scene.service";
import {SubjectService} from "../../service/subject.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-scene-display',
  standalone: true,
  imports: [],
  templateUrl: './scene-display.component.html',
  styleUrl: './scene-display.component.css'
})
export class SceneDisplayComponent implements OnInit{

  scenes: SceneDto[] = [];


  constructor(private sceneService: SceneService,
              private router: Router) {}

  ngOnInit(): void {
    this.sceneService.listActiveScenes();

    this.sceneService.scenes$.subscribe(resultData => {
      this.scenes = resultData;
    });
  }

  navigateTo(id: number) {
    this.router.navigate([`/forum/${id}`]);
  }
}
