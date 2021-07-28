import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { EmergencyContactInfoComponent } from './emergency-contact-info/emergency-contact-info.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { patientroutes } from './patient.routes';



@NgModule({
  declarations: [PatientDetailsComponent,EmergencyContactInfoComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forChild(patientroutes)
  ],
  exports:[PatientDetailsComponent,EmergencyContactInfoComponent]
})
export class PatientModule { }
