import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubjectRequirementComponent } from './subject-requirement.component';

describe('SubjectRequirementComponent', () => {
  let component: SubjectRequirementComponent;
  let fixture: ComponentFixture<SubjectRequirementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SubjectRequirementComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubjectRequirementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
