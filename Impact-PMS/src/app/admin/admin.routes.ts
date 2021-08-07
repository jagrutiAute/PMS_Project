import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { HospitalUsersComponent } from './hospital-users/hospital-users.component';
import { PatientUsersComponent } from './patient-users/patient-users.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';

import { EditPatientUsersComponent } from './edit-patient-users/edit-patient-users.component';
import { AddPatientUsersComponent } from './add-patient-users/add-patient-users.component';
import { CreateHospitalUserComponent } from './create-hospital-user/create-hospital-user.component';
import { UpdateHospitalUserComponent } from './update-hospital-user/update-hospital-user.component';

// http://localhost:4200/admin-dashboard/edit-patient-users/2
export var adminroutes: Route[] = [

    {
        path: 'admin-dashboard', component: AdminDashboardComponent,

        children: [

            {
                path: 'hospital-users',
                children: [
                    { path: '', component: HospitalUsersComponent },
                    { path: "create-user", component: CreateHospitalUserComponent },
                    { path: "update-user/:uid", component: UpdateHospitalUserComponent },

                ]
            },
            {
                path: 'patient-users',
                children: [
                    { path: '', component: PatientUsersComponent },
                    { path: 'edit-patient-users/:id', component: EditPatientUsersComponent },
                    { path: 'add-patient-users', component: AddPatientUsersComponent }
                ]

            }

        ]
    }
    // {
    //          path: 'admin-dashboard', component: AdminDashboardComponent,
    //          children: [
    // { path: '', redirectTo: 'patient-users', pathMatch: 'full' },
    // { path: 'patient-users', component: PatientUsersComponent },
    // { path: 'add-patient-users', component: AddPatientUsersComponent },
    // { path: 'edit-patient-users/:id', component: EditPatientUsersComponent }
    //          ]
    //         }
  ];
