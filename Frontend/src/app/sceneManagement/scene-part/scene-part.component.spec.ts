import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScenePartComponent } from './scene-part.component';

describe('ScenePartComponent', () => {
  let component: ScenePartComponent;
  let fixture: ComponentFixture<ScenePartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScenePartComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScenePartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
