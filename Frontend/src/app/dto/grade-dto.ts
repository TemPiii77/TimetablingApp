import {StudentDto} from "./student-dto";
import {TimeslotDto} from "./timeslot-dto";

export interface GradeDto {
  id : number
  value : number
  type : string
  comment : string
  dateRecorded : Date
  student : StudentDto
  timeslot : TimeslotDto
}
