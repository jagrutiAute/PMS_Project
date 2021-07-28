import { Route } from '@angular/router';
import { EmergencyContactInfoComponent } from './emergency-contact-info/emergency-contact-info.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';

export var patientroutes:Route[]=[
    
    {path:'patient-details', component:PatientDetailsComponent},
    {path:'emergency-contact-info', component:EmergencyContactInfoComponent}
]