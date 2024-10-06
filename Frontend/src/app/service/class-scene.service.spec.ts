import { TestBed } from '@angular/core/testing';

import { ClassSceneService } from './class-scene.service';

describe('ClassSceneService', () => {
  let service: ClassSceneService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClassSceneService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
