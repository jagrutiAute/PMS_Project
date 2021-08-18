import { ToasterService1 } from 'src/app/toaster-service.service';
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
import{userroutes } from './user.routes';
import { NotesComponent } from './notes/notes.component';
import { UpcomingAppointmentComponent } from './upcoming-appointment/upcoming-appointment.component'
import {MatInputModule} from '@angular/material/input';
import {TextFieldModule} from '@angular/cdk/text-field';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import {MatRadioModule} from '@angular/material/radio';

@NgModule({
  declarations: [
    LoginComponent,
    RegistrationProviderComponent,
    RegistrationPatientComponent,
    ChangePasswordComponent,
    ForgotPasswordComponent,
    NotesComponent,
    UpcomingAppointmentComponent
  ],
  providers: [LoginService,ToasterService1],
  imports: [
    MatRadioModule,
    TextFieldModule,
    MatInputModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forChild(userroutes)
  ],
  exports:[LoginComponent,RegistrationProviderComponent]
})
export class UserModule { }
