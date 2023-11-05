import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StartquizeComponent } from './startquize.component';

describe('StartquizeComponent', () => {
  let component: StartquizeComponent;
  let fixture: ComponentFixture<StartquizeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StartquizeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StartquizeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
