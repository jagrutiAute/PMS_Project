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

export var patientroutes:Route[]=[
    
    {path:'app-body-layout', canActivate:[AuthGuard], component:BodyLayoutComponent,

    children:[

        {path:'patient-details', component:PatientDetailsComponent},
        {path:'emergency-contact-info', component:EmergencyContactInfoComponent},
        {path:'allergy-details',component:AllergyDetailsComponent},
        { path: 'upcoming-appointments', component: UpcomingAppointmentsComponent },
        { path: 'recieved-notes', component: RecievedNotesComponent },
        { path: 'sent-notes', component: SentNotesComponent },
        { path: 'notes', component: NotesComponent },




       {path:'vital-signs',component:VitalSignsComponent},
      { path: 'medication',component: MedicationComponent },
      { path: 'book-appointment',component: BookAppointmentComponent },
      { path: 'app-patient-allergy-details',component: PatientAllergyDetailsComponent }
       

    ]
}
    
   
]


