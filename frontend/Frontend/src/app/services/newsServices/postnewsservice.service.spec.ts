import { TestBed } from '@angular/core/testing';

import { PostnewsserviceService } from './postnewsservice.service';

describe('PostnewsserviceService', () => {
  let service: PostnewsserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PostnewsserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
