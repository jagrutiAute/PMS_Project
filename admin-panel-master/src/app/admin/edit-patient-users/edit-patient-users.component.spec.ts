import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPatientUsersComponent } from './edit-patient-users.component';

describe('EditPatientUsersComponent', () => {
  let component: EditPatientUsersComponent;
  let fixture: ComponentFixture<EditPatientUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditPatientUsersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPatientUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
