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
import { MedicationComponent } from './medication/medication.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { AddMedicationComponent } from './add-medication/add-medication.component';

import { SchedulingComponent } from './scheduling/scheduling.component';
import {MatInputModule} from '@angular/material/input';
import { MatOptionModule } from '@angular/material/core';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatSelectModule} from '@angular/material/select';
import {OverlayModule} from '@angular/cdk/overlay';



@NgModule({
  declarations: [
    HospitalUsersComponent,
    PatientUsersComponent,
    AdminDashboardComponent,
    EditPatientUsersComponent,
    AddPatientUsersComponent,
    CreateHospitalUserComponent,
    UpdateHospitalUserComponent,
    MedicationComponent,
    PatientDetailsComponent,
    AddMedicationComponent,
    SchedulingComponent
    
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(adminroutes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2OrderModule,
    NgxPaginationModule,
    MatInputModule,
    MatOptionModule,
    MatAutocompleteModule,
    MatSelectModule,
    OverlayModule
    
    
    
  ],
   exports: [
    HospitalUsersComponent,
    PatientUsersComponent,
    AdminDashboardComponent
   
  ],
  providers:[AdminDashBoardService, HospitalUserService]
})
export class AdminModule { }
