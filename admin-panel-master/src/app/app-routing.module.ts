import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddPatientUsersComponent } from './admin/add-patient-users/add-patient-users.component';
import { DashboardComponent } from './dashboard/dashboard.component';


const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  
  { path: 'dashboard', component: DashboardComponent },

 {  
    path: 'admin',
 loadChildren: () => import('./admin/admin.module')
   .then(m => m.AdminModule),
  
},
{  
  path: 'patient',
loadChildren: () => import('./patient/patient.module')
 .then(m => m.PatientModule),

}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
