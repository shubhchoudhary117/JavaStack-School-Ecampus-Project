import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowquizesComponent } from './showquizes.component';

describe('ShowquizesComponent', () => {
  let component: ShowquizesComponent;
  let fixture: ComponentFixture<ShowquizesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowquizesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowquizesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
