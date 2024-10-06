import { TestBed } from '@angular/core/testing';

import { ScenePartService } from './scene-part.service';

describe('ScenePartService', () => {
  let service: ScenePartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScenePartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
