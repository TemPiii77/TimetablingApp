import { TestBed } from '@angular/core/testing';

import { TeacherSceneService } from './teacher-scene.service';

describe('TeacherSceneService', () => {
  let service: TeacherSceneService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TeacherSceneService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
