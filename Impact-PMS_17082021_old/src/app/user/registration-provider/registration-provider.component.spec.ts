import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationProviderComponent } from './registration-provider.component';

describe('RegistrationProviderComponent', () => {
  let component: RegistrationProviderComponent;
  let fixture: ComponentFixture<RegistrationProviderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrationProviderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
