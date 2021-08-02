
import { NgModule } from '@angular/core'
import { Route, RouterModule } from '@angular/router'
import { AdminDashboardComponent } from '../admin/admin-dashboard/admin-dashboard.component'
import { ChangePasswordComponent } from './change-password/change-password.component'
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component'
import { LoginComponent } from './login/login.component'
import { RegistrationPatientComponent } from './registration-patient/registration-patient.component'
import { RegistrationProviderComponent } from './registration-provider/registration-provider.component'


export var userroutes:Route[]=[
    {path:'login', component:LoginComponent},
    
    {path:'forgot-password', component:ForgotPasswordComponent},
    {path:'patient-registration', component:RegistrationPatientComponent},
    {path:'app-registration-provider', component:RegistrationProviderComponent},
    {path:'admin-dashboard', component:AdminDashboardComponent}
]

