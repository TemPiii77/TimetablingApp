import { TestBed } from '@angular/core/testing';

import { PreferredTimeService } from './preferred-time.service';

describe('PreferredTimeService', () => {
  let service: PreferredTimeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PreferredTimeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
