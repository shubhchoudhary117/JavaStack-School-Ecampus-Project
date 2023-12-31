import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonalprofileComponent } from './personalprofile.component';

describe('PersonalprofileComponent', () => {
  let component: PersonalprofileComponent;
  let fixture: ComponentFixture<PersonalprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersonalprofileComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PersonalprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
