import { MatRadioModule } from '@angular/material/radio';
import { ToasterService1 } from './../toaster-service.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TextFieldModule } from '@angular/cdk/text-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatFormFieldModule } from '@angular/material/form-field';
import { NotesComponent } from './notes/notes.component';
import { RecievedNotesComponent } from './recieved-notes/recieved-notes.component';
import { SentNotesComponent } from './sent-notes/sent-notes.component';
import { UpcomingAppointmentsComponent } from './upcoming-appointments/upcoming-appointments.component';
//import { inboxroutes } from './inbox.routes';
import { MatExpansionModule } from '@angular/material/expansion';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoteSortPipe } from './note-sort.pipe';
import { NoteIsurgentPipe } from './note-isurgent.pipe';


import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { PatientUpcomingAppoitmentsComponent } from './patient-upcoming-appoitments/patient-upcoming-appoitments.component';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [NotesComponent, RecievedNotesComponent, SentNotesComponent, UpcomingAppointmentsComponent, NoteSortPipe, NoteIsurgentPipe, PatientUpcomingAppoitmentsComponent],
  providers: [ToasterService1],
  imports: [
    MatButtonModule,
    CommonModule,
    MatRadioModule,
    TextFieldModule,
    MatInputModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatExpansionModule,
    NgxPaginationModule,
    Ng2OrderModule,
     MatDatepickerModule


    //  RouterModule.forChild(inboxroutes),
  ]

})
export class InboxModule { }
