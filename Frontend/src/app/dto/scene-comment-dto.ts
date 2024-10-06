import {UserDto} from "./user-dto";
import {ScenePartDto} from "./scene-part-dto";

export interface SceneCommentDto {
  id : number
  content : string
  dateRecorded : Date
  user : UserDto
  scenePart : ScenePartDto
}
