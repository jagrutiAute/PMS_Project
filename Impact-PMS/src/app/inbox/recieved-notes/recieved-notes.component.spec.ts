import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecievedNotesComponent } from './recieved-notes.component';

describe('RecievedNotesComponent', () => {
  let component: RecievedNotesComponent;
  let fixture: ComponentFixture<RecievedNotesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecievedNotesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecievedNotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
