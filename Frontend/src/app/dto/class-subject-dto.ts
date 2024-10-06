import {ClassSubjectIdDto} from "./class-subject-id-dto";
import {ClassDto} from "./class-dto";
import {SubjectDto} from "./subject-dto";

export interface ClassSubjectDto {
  id : ClassSubjectIdDto
  classField : ClassDto
  subject : SubjectDto
}
