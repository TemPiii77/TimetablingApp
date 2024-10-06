import {TeacherPreferredTimeIdDto} from "./teacher-preferred-time-id-dto";
import {TeacherDto} from "./teacher-dto";
import {PreferredTimeDto} from "./preferred-time-dto";

export interface TeacherPreferredTimeDto {
  id : TeacherPreferredTimeIdDto
  teacher : TeacherDto
  preferredTime : PreferredTimeDto
}
