import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhysicanSidenavComponent } from './physican-sidenav.component';

describe('PhysicanSidenavComponent', () => {
  let component: PhysicanSidenavComponent;
  let fixture: ComponentFixture<PhysicanSidenavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PhysicanSidenavComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PhysicanSidenavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
