import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VisitDetailsComponent } from './visit-details/visit-details.component';
import { VitalSignsComponent } from './vital-signs/vital-signs.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';



@NgModule({
  declarations: [
    VisitDetailsComponent,
    VitalSignsComponent
  ],
  imports: [
   
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class PatientVisitModule { }
