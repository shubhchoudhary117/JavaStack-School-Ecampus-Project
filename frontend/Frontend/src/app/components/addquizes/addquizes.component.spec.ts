import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddquizesComponent } from './addquizes.component';

describe('AddquizesComponent', () => {
  let component: AddquizesComponent;
  let fixture: ComponentFixture<AddquizesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddquizesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddquizesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
