import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegistrationProviderComponent } from './registration-provider/registration-provider.component';
import { RegistrationPatientComponent } from './registration-patient/registration-patient.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';



@NgModule({
  declarations: [
    LoginComponent,
    RegistrationProviderComponent,
    RegistrationPatientComponent,
    ChangePasswordComponent,
    ForgotPasswordComponent
  ],
  imports: [
    CommonModule
  ]
})
export class UserModule { }
