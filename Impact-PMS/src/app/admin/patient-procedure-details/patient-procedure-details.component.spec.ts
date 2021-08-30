import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientProcedureDetailsComponent } from './patient-procedure-details.component';

describe('PatientProcedureDetailsComponent', () => {
  let component: PatientProcedureDetailsComponent;
  let fixture: ComponentFixture<PatientProcedureDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientProcedureDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientProcedureDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
