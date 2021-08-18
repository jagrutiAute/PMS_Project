import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhysicanHeaderComponent } from './physican-header.component';

describe('PhysicanHeaderComponent', () => {
  let component: PhysicanHeaderComponent;
  let fixture: ComponentFixture<PhysicanHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PhysicanHeaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PhysicanHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
