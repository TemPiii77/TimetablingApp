import {StudentDto} from "./student-dto";
import {TimeslotDto} from "./timeslot-dto";

export interface DelayDto {
  id : number
  value : number
  comment : string
  dateRecorded : Date
  student : StudentDto
  timeslot : TimeslotDto
}
