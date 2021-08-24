import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { EmergencyContactInfoComponent } from './emergency-contact-info/emergency-contact-info.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { BodyLayoutComponent } from './body-layout/body-layout.component';
import { patientroutes } from './patient.routes';
import { AllergyDetailsComponent } from './allergy-details/allergy-details.component';
import { VitalSignsComponent } from '../patient-visit/vital-signs/vital-signs.component';
import {MatInputModule} from '@angular/material/input';


import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { MatTreeModule } from '@angular/material/tree';
import { SidenavComponent } from '../components/sidenav/sidenav.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from '../app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { HeaderComponent } from '../components/header/header.component';

import {MatButtonModule} from '@angular/material/button';
import {MatRadioModule} from '@angular/material/radio';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { MatFormFieldModule } from '@angular/material/form-field';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2OrderModule } from 'ng2-order-pipe';
import {MatDialogModule} from '@angular/material/dialog';
import { PatientAllergyDetailsComponent } from './patient-allergy-details/patient-allergy-details.component';
import { ToastrModule } from 'ngx-toastr';
import { ToasterService1 } from '../toaster-service.service';
import { MatSelectModule } from '@angular/material/select';
import { OverlayModule } from '@angular/cdk/overlay';



@NgModule({
  declarations: [PatientDetailsComponent, EmergencyContactInfoComponent, BodyLayoutComponent,AllergyDetailsComponent,
    HeaderComponent,SidenavComponent, PatientAllergyDetailsComponent],
  imports: [
    OverlayModule,
    ToastrModule.forRoot(),
    MatDialogModule,
    Ng2OrderModule,
    NgxPaginationModule,
   MatFormFieldModule,    
   MatAutocompleteModule,
    MatExpansionModule,
    MatRadioModule,
    MatButtonModule,
    MatSelectModule,
    MatInputModule,
    MatSidenavModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    // * MATERIAL IMPORTS
    MatSidenavModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
    MatTreeModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forChild(patientroutes)
  ],
  providers: [ToasterService1],
  exports: [PatientDetailsComponent, EmergencyContactInfoComponent, BodyLayoutComponent, AllergyDetailsComponent,HeaderComponent,SidenavComponent,PatientAllergyDetailsComponent]
})
export class PatientModule { }
