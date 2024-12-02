import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScenePartDisplayComponent } from './scene-part-display.component';

describe('ScenePartDisplayComponent', () => {
  let component: ScenePartDisplayComponent;
  let fixture: ComponentFixture<ScenePartDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScenePartDisplayComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScenePartDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
