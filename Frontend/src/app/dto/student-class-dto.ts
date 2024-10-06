import {StudentClassIdDto} from "./student-class-id-dto";
import {StudentDto} from "./student-dto";
import {ClassDto} from "./class-dto";

export interface StudentClassDto {
  id : StudentClassIdDto
  student : StudentDto
  classField : ClassDto
}
