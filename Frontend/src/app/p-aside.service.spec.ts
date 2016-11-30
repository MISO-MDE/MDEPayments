/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { PAsideService } from './p-aside.service';

describe('Service: PAside', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PAsideService]
    });
  });

  it('should ...', inject([PAsideService], (service: PAsideService) => {
    expect(service).toBeTruthy();
  }));
});
