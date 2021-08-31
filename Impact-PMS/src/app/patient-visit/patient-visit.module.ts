import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VisitDetailsComponent } from './visit-details/visit-details.component';
import { VitalSignsComponent } from './vital-signs/vital-signs.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { PatientVisitHistoryComponent } from './patient-visit-history/patient-visit-history.component';



@NgModule({
  declarations: [
    VisitDetailsComponent,
    VitalSignsComponent,
    PatientVisitHistoryComponent
  ],
  imports: [
   
    CommonModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports : [VitalSignsComponent,VisitDetailsComponent,PatientVisitHistoryComponent ]
})
export class PatientVisitModule { }
