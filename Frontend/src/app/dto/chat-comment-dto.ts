import {UserDto} from "./user-dto";
import {ChatDto} from "./chat-dto";

export interface ChatCommentDto {
  id : number
  content : string
  dateRecorded : Date
  user : UserDto
  chat : ChatDto
}
