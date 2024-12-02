import {Component, OnInit} from '@angular/core';
import {SceneDto} from "../../dto/scene-dto";
import {SceneService} from "../../service/scene.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ScenePartDto} from "../../dto/scene-part-dto";
import {ScenePartService} from "../../service/scene-part.service";

@Component({
  selector: 'app-scene-part-display',
  standalone: true,
  imports: [],
  templateUrl: './scene-part-display.component.html',
  styleUrl: './scene-part-display.component.css'
})
export class ScenePartDisplayComponent implements OnInit{

  sceneParts: ScenePartDto[] = [];
  scene: SceneDto | undefined;
  sceneId: Number | undefined;

  constructor(private scenePartService: ScenePartService,
              private router: Router,
              private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.sceneId = Number(params.get('sceneId'));

      console.log(this.sceneId)

      this.scenePartService.listScenePart(this.sceneId)
    });

    this.scenePartService.sceneParts$.subscribe(resultData => {
      this.sceneParts = resultData;

      if (this.sceneParts && this.sceneParts.length > 0) {
        this.scene = this.sceneParts[0].scene;
      }
    });
  }




  navigateTo(id: number) {
    this.router.navigate([`/forum/${this.sceneId}/${id}`]);
  }

}
