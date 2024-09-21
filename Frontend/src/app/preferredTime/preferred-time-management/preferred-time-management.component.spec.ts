import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreferredTimeManagementComponent } from './preferred-time-management.component';

describe('PreferredTimeManagementComponent', () => {
  let component: PreferredTimeManagementComponent;
  let fixture: ComponentFixture<PreferredTimeManagementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PreferredTimeManagementComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PreferredTimeManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
