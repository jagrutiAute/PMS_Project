import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelappointmentsComponent } from './cancelappointments.component';

describe('CancelappointmentsComponent', () => {
  let component: CancelappointmentsComponent;
  let fixture: ComponentFixture<CancelappointmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CancelappointmentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelappointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
