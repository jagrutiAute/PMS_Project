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
import { NgxPaginationModule } from 'ngx-pagination';
import { MedicationHistoryComponent } from './medication-history/medication-history.component';
import {MatButtonModule} from '@angular/material/button';
import { DiagnosisHistoryComponent } from './diagnosis-history/diagnosis-history.component';
import { ProcedureHistoryComponent } from './procedure-history/procedure-history.component';



@NgModule({
  declarations: [
    VisitDetailsComponent,
    VitalSignsComponent,
    PatientVisitHistoryComponent,
    PatientVitalSignComponent,
    MedicationHistoryComponent,
    DiagnosisHistoryComponent,
    ProcedureHistoryComponent
  ],
  imports: [
    MatFormFieldModule,
    MatInputModule,
   
    CommonModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
    MatButtonModule
  ],
  exports : [VitalSignsComponent,VisitDetailsComponent,PatientVisitHistoryComponent ]
})
export class PatientVisitModule { }
