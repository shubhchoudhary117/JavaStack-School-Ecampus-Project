import { TestBed } from '@angular/core/testing';

import { AdminProfileService } from './adminprofile.service';

describe('AdminProfileService', () => {
  let service: AdminProfileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminProfileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
