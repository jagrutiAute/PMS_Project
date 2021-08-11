import { NgModule, Pipe } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HospitalUsersComponent } from './hospital-users/hospital-users.component';
import { PatientUsersComponent } from './patient-users/patient-users.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { RouterModule } from '@angular/router';
import { adminroutes } from './admin.routes';
import { HttpClientModule } from '@angular/common/http';
import { AdminDashBoardService } from './admin.service';
import { EditPatientUsersComponent } from './edit-patient-users/edit-patient-users.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddPatientUsersComponent } from './add-patient-users/add-patient-users.component';
import { CreateHospitalUserComponent } from './create-hospital-user/create-hospital-user.component';
import { UpdateHospitalUserComponent } from './update-hospital-user/update-hospital-user.component';
import { HospitalUserService } from './hospital-user.service';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    HospitalUsersComponent,
    PatientUsersComponent,
    AdminDashboardComponent,
    EditPatientUsersComponent,
    AddPatientUsersComponent,
    CreateHospitalUserComponent,
    UpdateHospitalUserComponent
    
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(adminroutes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2OrderModule,
    NgxPaginationModule
    
  ],
   exports: [
    HospitalUsersComponent,
    PatientUsersComponent,
    AdminDashboardComponent
   
  ],
  providers:[AdminDashBoardService, HospitalUserService]
})
export class AdminModule { }
