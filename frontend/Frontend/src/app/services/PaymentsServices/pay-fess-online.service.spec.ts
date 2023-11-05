import { TestBed } from '@angular/core/testing';

import { PayFessOnlineService } from './pay-fess-online.service';

describe('PayFessOnlineService', () => {
  let service: PayFessOnlineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PayFessOnlineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
