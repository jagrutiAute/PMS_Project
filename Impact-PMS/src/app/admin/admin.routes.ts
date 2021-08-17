import { NotesComponent } from './../user/notes/notes.component';
import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { HospitalUsersComponent } from './hospital-users/hospital-users.component';
import { PatientUsersComponent } from './patient-users/patient-users.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';

//import { EditPatientUsersComponent } from './edit-patient-users/edit-patient-users.component';
import { AddPatientUsersComponent } from './add-patient-users/add-patient-users.component';
import { CreateHospitalUserComponent } from './create-hospital-user/create-hospital-user.component';
import { UpdateHospitalUserComponent } from './update-hospital-user/update-hospital-user.component';
import { EditPatientUsersComponent } from './edit-patient-users/edit-patient-users.component';
import { MedicationComponent } from './medication/medication.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { AddMedicationComponent } from './add-medication/add-medication.component';
import { SchedulingComponent } from './scheduling/scheduling.component';

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
                    { path: 'edit-patient-users/:id', component: EditPatientUsersComponent }

                    // { path: 'add-patient-users', component: AddPatientUsersComponent }
                ]

            },
            {
                path: 'medication',
                children: [
                    { path: '', component: MedicationComponent }
                    // { path: 'add-medication', component: AddMedicationComponent }


                ]
            },

            {
                path: 'notes', component: NotesComponent

            },
            {
                path: 'patient-details',
                children: [
                    { path: '', component: PatientDetailsComponent }


                ]


            },
            {
                path: 'scheduling', component: SchedulingComponent

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
