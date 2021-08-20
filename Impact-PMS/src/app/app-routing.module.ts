import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { BodyLayoutComponent } from './patient/body-layout/body-layout.component';
import { PatientDetailsComponent } from './patient/patient-details/patient-details.component';
import { LoginComponent } from './user/login/login.component';
import { UserModule } from './user/user.module';

export const routes: Routes = [

    {path:"",component:LoginComponent},
    {path:'home',component:LoginComponent} ,
    {path:'accessDenied',component:NotFoundComponent},
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
