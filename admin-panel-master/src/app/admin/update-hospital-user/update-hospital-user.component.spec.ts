import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateHospitalUserComponent } from './update-hospital-user.component';

describe('UpdateHospitalUserComponent', () => {
  let component: UpdateHospitalUserComponent;
  let fixture: ComponentFixture<UpdateHospitalUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateHospitalUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateHospitalUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
