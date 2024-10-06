import { TestBed } from '@angular/core/testing';

import { SubjectRequirementService } from './subject-requirement.service';

describe('SubjectRequirementService', () => {
  let service: SubjectRequirementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubjectRequirementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
