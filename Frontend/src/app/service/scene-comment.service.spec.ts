import { TestBed } from '@angular/core/testing';

import { SceneCommentService } from './scene-comment.service';

describe('SceneCommentService', () => {
  let service: SceneCommentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SceneCommentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
