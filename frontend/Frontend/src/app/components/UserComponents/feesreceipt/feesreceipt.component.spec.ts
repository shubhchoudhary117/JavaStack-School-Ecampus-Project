import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeesreceiptComponent } from './feesreceipt.component';

describe('FeesreceiptComponent', () => {
  let component: FeesreceiptComponent;
  let fixture: ComponentFixture<FeesreceiptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeesreceiptComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FeesreceiptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
