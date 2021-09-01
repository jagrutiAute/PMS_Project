import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VisitDetailsComponent } from './visit-details/visit-details.component';
import { VitalSignsComponent } from './vital-signs/vital-signs.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { PatientVisitHistoryComponent } from './patient-visit-history/patient-visit-history.component';
import { PatientVitalSignComponent } from './patient-vital-sign/patient-vital-sign.component';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';




@NgModule({
  declarations: [
    VisitDetailsComponent,
    VitalSignsComponent,
    PatientVisitHistoryComponent,
    PatientVitalSignComponent
  ],
  imports: [
    MatFormFieldModule,
    MatInputModule,
   
    CommonModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports : [VitalSignsComponent,VisitDetailsComponent,PatientVisitHistoryComponent ]
})
export class PatientVisitModule { }
