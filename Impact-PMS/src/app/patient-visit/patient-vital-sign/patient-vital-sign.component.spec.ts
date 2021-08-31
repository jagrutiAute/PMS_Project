import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientVitalSignComponent } from './patient-vital-sign.component';

describe('PatientVitalSignComponent', () => {
  let component: PatientVitalSignComponent;
  let fixture: ComponentFixture<PatientVitalSignComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientVitalSignComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientVitalSignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
