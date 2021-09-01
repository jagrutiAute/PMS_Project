import { AllergyDetailsComponent } from './allergy-details/allergy-details.component';
import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { BodyLayoutComponent } from './body-layout/body-layout.component';
import { EmergencyContactInfoComponent } from './emergency-contact-info/emergency-contact-info.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { ChangePasswordComponent } from '../user/change-password/change-password.component';
import { VitalSignsComponent } from '../patient-visit/vital-signs/vital-signs.component';
import { AuthGuard } from '../auth.guard';
import { MedicationComponent } from '../admin/medication/medication.component';
import { BookAppointmentComponent } from '../admin/book-appointment/book-appointment.component';
import { PatientAllergyDetailsComponent } from './patient-allergy-details/patient-allergy-details.component';
import { UpcomingAppointmentsComponent } from '../inbox/upcoming-appointments/upcoming-appointments.component';
import { RecievedNotesComponent } from '../inbox/recieved-notes/recieved-notes.component';
import { SentNotesComponent } from '../inbox/sent-notes/sent-notes.component';
import { NotesComponent } from '../inbox/notes/notes.component';
import { CancelappointmentsComponent } from './cancelappointments/cancelappointments.component';
import { PatientUpcomingAppoitmentsComponent } from '../inbox/patient-upcoming-appoitments/patient-upcoming-appoitments.component';
import { PatientVitalSignComponent } from '../patient-visit/patient-vital-sign/patient-vital-sign.component';
import { ProcedureComponent } from '../admin/procedure/procedure.component';
import { PatientProcedureDetailsComponent } from '../admin/patient-procedure-details/patient-procedure-details.component';
import { PatientDetailsComponent1 } from '../admin/patient-details/patient-details.component';
import { PatientDiagnosisComponent } from '../admin/patient-diagnosis/patient-diagnosis.component';

export var patientroutes:Route[]=[
    
    {path:'app-body-layout', component:BodyLayoutComponent,
    //, canActivate:[AuthGuard]

    children:[

        {path:'patient-details', component:PatientDetailsComponent},
        {path:'emergency-contact-info', component:EmergencyContactInfoComponent},
        {path:'allergy-details',component:AllergyDetailsComponent},
        { path: 'upcoming-appointments', component: UpcomingAppointmentsComponent },
        { path: 'recieved-notes', component: RecievedNotesComponent },
        { path: 'sent-notes', component: SentNotesComponent },
        { path: 'notes', component: NotesComponent },
        {path:'cancelled-appoitments',component:CancelappointmentsComponent},
        {path:'patient-upcoming-appoitments',component:PatientUpcomingAppoitmentsComponent},




       {path:'vital-signs',component:VitalSignsComponent},
      { path: 'medication',component: MedicationComponent },
     
      { path: 'book-appointment',component: BookAppointmentComponent },
      { path: 'app-patient-allergy-details',component: PatientAllergyDetailsComponent },
      { path: 'patient-vital-sign',component: PatientVitalSignComponent },
      { path: 'procedure',component: PatientProcedureDetailsComponent },
      { path: 'showmedication',component: PatientDetailsComponent1 },
      { path: 'showdiagnosis',component: PatientDiagnosisComponent }
      

    ]
}
    
   
]


