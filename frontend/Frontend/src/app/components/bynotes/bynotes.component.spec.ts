import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BynotesComponent } from './bynotes.component';

describe('BynotesComponent', () => {
  let component: BynotesComponent;
  let fixture: ComponentFixture<BynotesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BynotesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BynotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
