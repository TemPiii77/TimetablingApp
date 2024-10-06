import { TestBed } from '@angular/core/testing';

import { ChatCommentService } from './chat-comment.service';

describe('ChatCommentService', () => {
  let service: ChatCommentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChatCommentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
