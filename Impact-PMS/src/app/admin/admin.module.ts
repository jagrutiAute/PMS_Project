import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HospitalUsersComponent } from './hospital-users/hospital-users.component';
import { PatientUsersComponent } from './patient-users/patient-users.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { RouterModule } from '@angular/router';
import { adminroutes } from './admin.routes';
import { HttpClientModule } from '@angular/common/http';
import { AdminDashBoardService } from './admin.service';
import { EditPatientUsersComponent } from './edit-patient-users/edit-patient-users.component';
import { FormsModule } from '@angular/forms';
import { AddPatientUsersComponent } from './add-patient-users/add-patient-users.component';

@NgModule({
  declarations: [
    HospitalUsersComponent,
    PatientUsersComponent,
    AdminDashboardComponent,
    EditPatientUsersComponent,
    AddPatientUsersComponent
    
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(adminroutes),HttpClientModule,FormsModule
  ],
   exports: [
    HospitalUsersComponent,
    PatientUsersComponent,
    AdminDashboardComponent
   
  ],
  providers:[AdminDashBoardService]
})
export class AdminModule { }
