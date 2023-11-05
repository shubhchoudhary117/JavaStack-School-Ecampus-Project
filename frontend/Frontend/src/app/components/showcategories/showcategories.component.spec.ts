import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowcategoriesComponent } from './showcategories.component';

describe('ShowcategoriesComponent', () => {
  let component: ShowcategoriesComponent;
  let fixture: ComponentFixture<ShowcategoriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowcategoriesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowcategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
