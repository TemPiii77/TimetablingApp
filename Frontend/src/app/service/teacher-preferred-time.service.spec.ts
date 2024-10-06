import { TestBed } from '@angular/core/testing';

import { TeacherPreferredTimeService } from './teacher-preferred-time.service';

describe('TeacherPreferredTimeService', () => {
  let service: TeacherPreferredTimeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TeacherPreferredTimeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
