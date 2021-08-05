import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateHospitalUserComponent } from './create-hospital-user.component';

describe('CreateHospitalUserComponent', () => {
  let component: CreateHospitalUserComponent;
  let fixture: ComponentFixture<CreateHospitalUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateHospitalUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateHospitalUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
