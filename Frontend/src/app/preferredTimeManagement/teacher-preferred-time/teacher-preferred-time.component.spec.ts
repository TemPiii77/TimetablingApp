import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherPreferredTimeComponent } from './teacher-preferred-time.component';

describe('TeacherPreferredTimeComponent', () => {
  let component: TeacherPreferredTimeComponent;
  let fixture: ComponentFixture<TeacherPreferredTimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TeacherPreferredTimeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TeacherPreferredTimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
