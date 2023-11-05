import { TestBed } from '@angular/core/testing';

import { StudentFeesDetailsServiceService } from './student-fees-details-service.service';

describe('StudentFeesDetailsServiceService', () => {
  let service: StudentFeesDetailsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentFeesDetailsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
