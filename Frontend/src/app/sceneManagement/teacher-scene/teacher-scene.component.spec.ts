import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherSceneComponent } from './teacher-scene.component';

describe('TeacherSceneComponent', () => {
  let component: TeacherSceneComponent;
  let fixture: ComponentFixture<TeacherSceneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TeacherSceneComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TeacherSceneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
