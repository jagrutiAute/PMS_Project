import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { BodyLayoutComponent } from './patient/body-layout/body-layout.component';
import { PatientDetailsComponent } from './patient/patient-details/patient-details.component';
import { LoginComponent } from './user/login/login.component';
import { UserModule } from './user/user.module';

export const routes: Routes = [

    {path:"",component:LoginComponent},
    {path:'home',component:LoginComponent} 
  //  {path:'app-body-layout',component:BodyLayoutComponent,
  
 // children:[{
 //  path:'patient/patient-details',component:PatientDetailsComponent
  // }]
  
 //}
    
];

@NgModule({
  
  exports: [RouterModule]
})
export class AppRoutingModule { }
