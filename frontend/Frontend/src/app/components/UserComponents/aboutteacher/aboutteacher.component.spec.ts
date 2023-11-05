import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutteacherComponent } from './aboutteacher.component';

describe('AboutteacherComponent', () => {
  let component: AboutteacherComponent;
  let fixture: ComponentFixture<AboutteacherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AboutteacherComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AboutteacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
