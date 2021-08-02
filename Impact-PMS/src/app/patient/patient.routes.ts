import { AllergyDetailsComponent } from './allergy-details/allergy-details.component';
import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { BodyLayoutComponent } from './body-layout/body-layout.component';
import { EmergencyContactInfoComponent } from './emergency-contact-info/emergency-contact-info.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { ChangePasswordComponent } from '../user/change-password/change-password.component';

export var patientroutes:Route[]=[
    
    {path:'app-body-layout', component:BodyLayoutComponent,

    children:[

        {path:'patient-details', component:PatientDetailsComponent},
        {path:'emergency-contact-info', component:EmergencyContactInfoComponent},
        {path:'allergy-details',component:AllergyDetailsComponent},
        {path:'change-password',component:ChangePasswordComponent}

    ]
}
    
   
]


