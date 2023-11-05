import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizequestionsComponent } from './quizequestions.component';

describe('QuizequestionsComponent', () => {
  let component: QuizequestionsComponent;
  let fixture: ComponentFixture<QuizequestionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuizequestionsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuizequestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
