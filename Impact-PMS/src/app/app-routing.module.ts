import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PatientDetailsComponent } from './patient/patient-details/patient-details.component';
import { LoginComponent } from './user/login/login.component';
import { UserModule } from './user/user.module';

const routes: Routes = [

    {path:"",component:LoginComponent},
    {path:'home',component:LoginComponent},
    {path:'patient-details',component:PatientDetailsComponent}
    
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
