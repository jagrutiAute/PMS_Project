import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { BodyLayoutComponent } from './body-layout/body-layout.component';
import { EmergencyContactInfoComponent } from './emergency-contact-info/emergency-contact-info.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';

export var patientroutes:Route[]=[
    
    {path:'app-body-layout', component:BodyLayoutComponent,

    children:[

        {path:'patient-details', component:PatientDetailsComponent},
        {path:'emergency-contact-info', component:EmergencyContactInfoComponent}

    ]
}
    
   
]


