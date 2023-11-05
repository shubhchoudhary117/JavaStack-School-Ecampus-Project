import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoemailComponent } from './doemail.component';

describe('DoemailComponent', () => {
  let component: DoemailComponent;
  let fixture: ComponentFixture<DoemailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoemailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoemailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
