import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NurseSidenavComponent } from './nurse-sidenav.component';

describe('NurseSidenavComponent', () => {
  let component: NurseSidenavComponent;
  let fixture: ComponentFixture<NurseSidenavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NurseSidenavComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NurseSidenavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
