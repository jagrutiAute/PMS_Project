import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhysicanDashboardComponent } from './physican-dashboard.component';

describe('PhysicanDashboardComponent', () => {
  let component: PhysicanDashboardComponent;
  let fixture: ComponentFixture<PhysicanDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PhysicanDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PhysicanDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
