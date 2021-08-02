import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { HospitalUsersComponent } from './hospital-users/hospital-users.component';
import { PatientUsersComponent } from './patient-users/patient-users.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';

export var adminroutes: Route[] = [

    {
        path: 'admin-dashboard', component: AdminDashboardComponent,

        children: [

            { path: 'hospital-users', component: HospitalUsersComponent },
            { path: 'patient-users', component: PatientUsersComponent }
        ]
    }


]


