import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassContainerComponent } from './class-container.component';

describe('ClassContainerComponent', () => {
  let component: ClassContainerComponent;
  let fixture: ComponentFixture<ClassContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClassContainerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClassContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
