
import { NgModule } from '@angular/core'
import { Route, RouterModule } from '@angular/router'
import { ChangePasswordComponent } from './change-password/change-password.component'
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component'
import { LoginComponent } from './login/login.component'


export var userroutes:Route[]=[
    {path:'login', component:LoginComponent},
    {path:'change-password',component:ChangePasswordComponent},
    {path:'forgot-password', component:ForgotPasswordComponent}
]

