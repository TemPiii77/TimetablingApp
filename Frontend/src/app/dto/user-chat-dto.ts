import {UserDto} from "./user-dto";
import {ChatDto} from "./chat-dto";

export interface UserChatDto {
  id : UserChatDto
  user : UserDto
  chat : ChatDto
}
