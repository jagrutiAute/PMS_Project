import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HospitalUsersComponent } from './hospital-users/hospital-users.component';
import { PatientUsersComponent } from './patient-users/patient-users.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { RouterModule } from '@angular/router';
import { adminroutes } from './admin.routes';



@NgModule({
  declarations: [
    HospitalUsersComponent,
    PatientUsersComponent,
    AdminDashboardComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(adminroutes)
  ], exports: [
    HospitalUsersComponent,
    PatientUsersComponent,
    AdminDashboardComponent
  ]
})
export class AdminModule { }
