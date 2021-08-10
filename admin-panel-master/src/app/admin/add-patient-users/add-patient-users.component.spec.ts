import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPatientUsersComponent } from './add-patient-users.component';

describe('AddPatientUsersComponent', () => {
  let component: AddPatientUsersComponent;
  let fixture: ComponentFixture<AddPatientUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPatientUsersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPatientUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
