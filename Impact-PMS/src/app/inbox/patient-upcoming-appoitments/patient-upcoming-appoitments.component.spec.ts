import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientUpcomingAppoitmentsComponent } from './patient-upcoming-appoitments.component';

describe('PatientUpcomingAppoitmentsComponent', () => {
  let component: PatientUpcomingAppoitmentsComponent;
  let fixture: ComponentFixture<PatientUpcomingAppoitmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientUpcomingAppoitmentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientUpcomingAppoitmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
