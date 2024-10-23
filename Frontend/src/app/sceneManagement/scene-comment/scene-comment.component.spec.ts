import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SceneCommentComponent } from './scene-comment.component';

describe('SceneCommentComponent', () => {
  let component: SceneCommentComponent;
  let fixture: ComponentFixture<SceneCommentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SceneCommentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SceneCommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
