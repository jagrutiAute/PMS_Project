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
<<<<<<< HEAD
//import { CalendarModule, DateAdapter } from 'angular-calendar';
//import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
=======
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { ToasterService1 } from './toaster-service.service';
import { ToastrModule } from 'ngx-toastr';


>>>>>>> d062d680857e2f328d13d33e98d6533befcf8875


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
<<<<<<< HEAD
   // NbThemeModule.forRoot(),
    //CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory })
=======
    NbThemeModule.forRoot(),
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory }),
    ToastrModule.forRoot(),
    BrowserAnimationsModule
    
>>>>>>> d062d680857e2f328d13d33e98d6533befcf8875
  ],
  providers: [ToasterService1],
  bootstrap: [AppComponent]
})
export class AppModule { }
