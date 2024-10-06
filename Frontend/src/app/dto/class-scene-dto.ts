import {ClassSceneIdDto} from "./class-scene-id-dto";
import {ClassDto} from "./class-dto";
import {SceneDto} from "./scene-dto";

export interface ClassSceneDto {
  id : ClassSceneIdDto
  classField : ClassDto
  scene : SceneDto
}
