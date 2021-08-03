import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppRoutingModule, routes } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatientModule } from './patient/patient.module';
import { LoginComponent } from './user/login/login.component';
import { UserModule } from './user/user.module';
import { AdminModule } from './admin/admin.module';
import { adminroutes } from './admin/admin.routes';
import { PatientVisitModule } from './patient-visit/patient-visit.module';

@NgModule({
  declarations: [
    AppComponent  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    AdminModule,
    PatientVisitModule,
    PatientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
