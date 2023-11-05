import { TestBed } from '@angular/core/testing';

import { StudentreletedService } from './studentreleted.service';

describe('StudentreletedService', () => {
  let service: StudentreletedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentreletedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
