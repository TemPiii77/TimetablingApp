import {StudentDto} from "./student-dto";
import {TimeslotDto} from "./timeslot-dto";

export interface AbsenceDto {
  id : number
  comment : string
  dateRecorded : Date
  student : StudentDto
  timeslot : TimeslotDto
}
