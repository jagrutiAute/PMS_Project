import { Route } from '@angular/router';
import { AllergyDetailsComponent } from './allergy-details/allergy-details.component';
import { EmergencyContactInfoComponent } from './emergency-contact-info/emergency-contact-info.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';

export var patientroutes:Route[]=[
    
    {path:'patient-details', component:PatientDetailsComponent},
    {path:'emergency-contact-info', component:EmergencyContactInfoComponent},
    {path:'allergy-details',component:AllergyDetailsComponent}
]