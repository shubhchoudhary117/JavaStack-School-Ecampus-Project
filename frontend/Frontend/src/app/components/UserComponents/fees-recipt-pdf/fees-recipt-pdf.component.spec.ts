import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeesReciptPdfComponent } from './fees-recipt-pdf.component';

describe('FeesReciptPdfComponent', () => {
  let component: FeesReciptPdfComponent;
  let fixture: ComponentFixture<FeesReciptPdfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeesReciptPdfComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FeesReciptPdfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
