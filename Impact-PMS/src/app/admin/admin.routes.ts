import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { HospitalUsersComponent } from './hospital-users/hospital-users.component';
import { PatientUsersComponent } from './patient-users/patient-users.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';

import { EditPatientUsersComponent } from './edit-patient-users/edit-patient-users.component';
import { AddPatientUsersComponent } from './add-patient-users/add-patient-users.component';

// http://localhost:4200/admin-dashboard/edit-patient-users/2
export var adminroutes: Route[] = [

    {
        path: 'admin-dashboard', component: AdminDashboardComponent,

        children: [

            { path: 'hospital-users', component: HospitalUsersComponent },

            {
                path: 'patient-users',
                children: [
                    {path: '', component: PatientUsersComponent},
                    { path: 'edit-patient-users/:id', component: EditPatientUsersComponent },
                    { path: 'add-patient-users', component: EditPatientUsersComponent }
                ]

            }

        ]
    }
]



