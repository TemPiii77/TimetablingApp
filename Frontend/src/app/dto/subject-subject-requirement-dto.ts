import {SubjectSubjectRequirementIdDto} from "./subject-subject-requirement-id-dto";
import {SubjectDto} from "./subject-dto";
import {SubjectRequirementDto} from "./subject-requirement-dto";

export interface SubjectSubjectRequirementDto {
  id : SubjectSubjectRequirementIdDto
  subject : SubjectDto
  subjectRequirement : SubjectRequirementDto
}
