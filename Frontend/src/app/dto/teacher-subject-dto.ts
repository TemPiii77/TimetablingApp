import {TeacherSubjectIdDto} from "./teacher-subject-id-dto";
import {TeacherDto} from "./teacher-dto";
import {SubjectDto} from "./subject-dto";

export interface TeacherSubjectDto {
  id : TeacherSubjectIdDto
  teacher : TeacherDto
  subject : SubjectDto
}
