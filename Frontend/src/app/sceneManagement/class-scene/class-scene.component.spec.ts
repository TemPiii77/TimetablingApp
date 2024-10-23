import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassSceneComponent } from './class-scene.component';

describe('ClassSceneComponent', () => {
  let component: ClassSceneComponent;
  let fixture: ComponentFixture<ClassSceneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClassSceneComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClassSceneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
