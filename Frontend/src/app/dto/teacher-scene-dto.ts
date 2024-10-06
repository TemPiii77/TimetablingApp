import {TeacherSceneIdDto} from "./teacher-scene-id-dto";
import {TeacherDto} from "./teacher-dto";
import {SceneDto} from "./scene-dto";

export interface TeacherSceneDto {
  id : TeacherSceneIdDto
  teacher : TeacherDto
  scene : SceneDto
}
