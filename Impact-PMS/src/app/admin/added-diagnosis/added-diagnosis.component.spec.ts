import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddedDiagnosisComponent } from './added-diagnosis.component';

describe('AddedDiagnosisComponent', () => {
  let component: AddedDiagnosisComponent;
  let fixture: ComponentFixture<AddedDiagnosisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddedDiagnosisComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddedDiagnosisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
