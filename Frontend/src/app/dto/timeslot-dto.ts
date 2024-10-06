import {ClassDto} from "./class-dto";
import {TeacherDto} from "./teacher-dto";
import {SubjectDto} from "./subject-dto";
import {ClassroomDto} from "./classroom-dto";

export interface TimeslotDto {
  id : number
  year : number
  day : string
  hour : number
  classField : ClassDto
  teacher : TeacherDto
  subject : SubjectDto
  classroom : ClassroomDto
}
