import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SceneCommentDisplayComponent } from './scene-comment-display.component';

describe('SceneCommentDisplayComponent', () => {
  let component: SceneCommentDisplayComponent;
  let fixture: ComponentFixture<SceneCommentDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SceneCommentDisplayComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SceneCommentDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
