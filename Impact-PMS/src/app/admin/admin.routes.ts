import { UpcomingAppointmentComponent } from './../user/upcoming-appointment/upcoming-appointment.component';

import { NgModule, Component } from '@angular/core';
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
import { AdminGuard } from '../admin.guard';

import { PhysicianGuard } from '../physician.guard';
import { PhysicianDashboardComponent } from './physician-dashboard/physician-dashboard.component';
import { NurseDashboardComponent } from './nurse-dashboard/nurse-dashboard.component';
import { NurseGuard } from '../nurse.guard';
import { NotesComponent } from '../inbox/notes/notes.component';
import { UpcomingAppointmentsComponent } from '../inbox/upcoming-appointments/upcoming-appointments.component';
import { RecievedNotesComponent } from '../inbox/recieved-notes/recieved-notes.component';
import { SentNotesComponent } from '../inbox/sent-notes/sent-notes.component';
import { DiagnosisComponent } from './diagnosis/diagnosis.component';

// http://localhost:4200/admin-dashboard/edit-patient-users/2


export var adminroutes: Route[] = [

    {
        path: 'admin-dashboard', component: AdminDashboardComponent,
        //, canActivate: [AdminGuard]

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


        ],



    },
    {
        path: 'physician-dashboard', component: PhysicianDashboardComponent,
        children: [
            {
                path: 'notes', component: NotesComponent

            },
            { path: 'upcoming-appointments', component: UpcomingAppointmentsComponent },
            { path: 'recieved-notes', component: RecievedNotesComponent },
            { path: 'sent-notes', component: SentNotesComponent },
            {
                path: 'patient-details', component: PatientDetailsComponent



            },
            {
                path: 'scheduling', component: SchedulingComponent

            },
            {
                path: 'medication',
                children: [
                    { path: '', component: MedicationComponent }
                    // { path: 'add-medication', component: AddMedicationComponent }


                ]
            },
            {
                path: 'diagnosis', component: DiagnosisComponent

            }
        ]
    },
    {
        path: 'nurse-dashboard', component: NurseDashboardComponent,
        children: [
            {
                path: 'notes', component: NotesComponent

            }, { path: 'upcoming-appointments', component: UpcomingAppointmentsComponent },
            { path: 'recieved-notes', component: RecievedNotesComponent },
            { path: 'sent-notes', component: SentNotesComponent },
            { path: 'notes', component: NotesComponent },
            { path: 'upcoming-appointment', component: UpcomingAppointmentComponent },
            {
                path: 'patient-details', component: PatientDetailsComponent



            },
            {
                path: 'scheduling', component: SchedulingComponent

            },
            {
                path: 'medication',
                children: [
                    { path: '', component: MedicationComponent }
                    // { path: 'add-medication', component: AddMedicationComponent }


                ]
            }
        ]
    }
];
