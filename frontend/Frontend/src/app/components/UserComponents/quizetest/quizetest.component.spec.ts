import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizetestComponent } from './quizetest.component';

describe('QuizetestComponent', () => {
  let component: QuizetestComponent;
  let fixture: ComponentFixture<QuizetestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuizetestComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuizetestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
