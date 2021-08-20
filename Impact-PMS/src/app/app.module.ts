import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule, routes } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatientModule } from './patient/patient.module';
import { UserModule } from './user/user.module';
import { AdminModule } from './admin/admin.module';

import { PatientVisitModule } from './patient-visit/patient-visit.module';
import { NbThemeModule } from '@nebular/theme';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { ToasterService1 } from './toaster-service.service';
import { ToastrModule } from 'ngx-toastr';




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
    PatientModule,
   // NbThemeModule.forRoot(),
    //CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory })
    NbThemeModule.forRoot(),
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory }),
    ToastrModule.forRoot(),
    BrowserAnimationsModule
    
  ],
  providers: [ToasterService1],
  bootstrap: [AppComponent]
})
export class AppModule { }
