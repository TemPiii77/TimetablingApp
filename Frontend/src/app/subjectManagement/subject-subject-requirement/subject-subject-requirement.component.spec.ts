import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectSubjectRequirementComponent } from './subject-subject-requirement.component';

describe('SubjectSubjectRequirementComponent', () => {
  let component: SubjectSubjectRequirementComponent;
  let fixture: ComponentFixture<SubjectSubjectRequirementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SubjectSubjectRequirementComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubjectSubjectRequirementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
