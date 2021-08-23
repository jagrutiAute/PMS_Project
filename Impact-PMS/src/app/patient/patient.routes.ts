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

export var patientroutes:Route[]=[
    
    {path:'app-body-layout', canActivate:[AuthGuard], component:BodyLayoutComponent,

    children:[

        {path:'patient-details', component:PatientDetailsComponent},
        {path:'emergency-contact-info', component:EmergencyContactInfoComponent},
        {path:'allergy-details',component:AllergyDetailsComponent},
        {path:'change-password',component:ChangePasswordComponent},
       {path:'vital-signs',component:VitalSignsComponent},
      { path: 'medication',component: MedicationComponent },
      { path: 'book-appointment',component: BookAppointmentComponent }
       

    ]
}
    
   
]


