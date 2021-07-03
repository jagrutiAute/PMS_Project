import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegistrationProviderComponent } from './registration-provider/registration-provider.component';
import { RegistrationPatientComponent } from './registration-patient/registration-patient.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './login.service';
import { RouterModule } from '@angular/router';
import{userroutes } from './user.routes'



@NgModule({
  declarations: [
    LoginComponent,
    RegistrationProviderComponent,
    RegistrationPatientComponent,
    ChangePasswordComponent,
    ForgotPasswordComponent
  ],
  providers: [LoginService],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forChild(userroutes)
  ],
  exports:[LoginComponent]
})
export class UserModule { }
