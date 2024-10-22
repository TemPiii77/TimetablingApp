import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreferredTimeContainerComponent } from './preferred-time-container.component';

describe('PreferredTimeContainerComponent', () => {
  let component: PreferredTimeContainerComponent;
  let fixture: ComponentFixture<PreferredTimeContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PreferredTimeContainerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PreferredTimeContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
