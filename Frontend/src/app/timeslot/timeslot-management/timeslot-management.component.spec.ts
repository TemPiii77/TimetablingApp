import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimeslotManagementComponent } from './timeslot-management.component';

describe('TimeslotManagementComponent', () => {
  let component: TimeslotManagementComponent;
  let fixture: ComponentFixture<TimeslotManagementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TimeslotManagementComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TimeslotManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
