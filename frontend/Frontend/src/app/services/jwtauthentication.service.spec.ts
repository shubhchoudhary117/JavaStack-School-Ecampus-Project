import { TestBed } from '@angular/core/testing';

import { JwtauthenticationService } from './jwtauthentication.service';

describe('JwtauthenticationService', () => {
  let service: JwtauthenticationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JwtauthenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
