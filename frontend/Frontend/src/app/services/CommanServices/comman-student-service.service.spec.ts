import { TestBed } from '@angular/core/testing';

import { CommanStudentServiceService } from './comman-student-service.service';

describe('CommanStudentServiceService', () => {
  let service: CommanStudentServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommanStudentServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
