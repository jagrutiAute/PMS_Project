import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientAllergyDetailsComponent } from './patient-allergy-details.component';

describe('PatientAllergyDetailsComponent', () => {
  let component: PatientAllergyDetailsComponent;
  let fixture: ComponentFixture<PatientAllergyDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientAllergyDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientAllergyDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
