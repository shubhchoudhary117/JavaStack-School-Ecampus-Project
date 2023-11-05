import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusrouteComponent } from './busroute.component';

describe('BusrouteComponent', () => {
  let component: BusrouteComponent;
  let fixture: ComponentFixture<BusrouteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusrouteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BusrouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
