import { TestBed } from '@angular/core/testing';

import { SubjectSubjectRequirementService } from './subject-subject-requirement.service';

describe('SubjectSubjectRequirementService', () => {
  let service: SubjectSubjectRequirementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubjectSubjectRequirementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
