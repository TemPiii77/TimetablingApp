import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreferredTimeComponent } from './preferred-time.component';

describe('PreferredTimeComponent', () => {
  let component: PreferredTimeComponent;
  let fixture: ComponentFixture<PreferredTimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PreferredTimeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PreferredTimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
