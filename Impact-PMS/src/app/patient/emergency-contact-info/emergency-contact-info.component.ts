import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { EmergencyContactInfo } from '../emergencyContactInfo';
import { PatientDetailService } from '../patient.service';
import { PatientDetails } from '../patientDetail';

@Component({
  selector: 'app-emergency-contact-info',
  templateUrl: './emergency-contact-info.component.html',
  styleUrls: ['./emergency-contact-info.component.css']
})
export class EmergencyContactInfoComponent implements OnInit {

  emergencyContactInfo: EmergencyContactInfo;
  patientDetails1:PatientDetails;
  id : number;
  

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service: PatientDetailService,
    private toaster:ToasterService1
  ) { }

  mrnId:string = sessionStorage.getItem('mrnNumber');

  ngOnInit(): void {

    this.service.getPatientEmergencyCntDetails(this.mrnId).subscribe(
      (data) => {
        console.log("getPatientEmergencyCntDetails() :::::  " + data)
        this.emergencyContactInfo=data;
        this.patientDetails1= this.emergencyContactInfo.patientDetails;
        this.id = this.emergencyContactInfo.id;
        
      }
    );
  }

 
  
  emergencyCntInfo = this.fb.group({

    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    homeAddress: ['', Validators.required],
    emergencyEmail: ['', Validators.required],
    emergencyContact: ['', Validators.required],
    patientPortalAccess: ['', Validators.required]

  });

  get f() {
    return this.emergencyCntInfo.controls;
  }

  updateEmergencyCntDetails() {

    
    let emergencyCntInfo: EmergencyContactInfo = new EmergencyContactInfo();

   emergencyCntInfo.patientDetails = this.patientDetails1;
   emergencyCntInfo.id = this.id;

    Object.assign(emergencyCntInfo, this.emergencyCntInfo.value);
    
    this.service.updateEmergencyCntDetails(emergencyCntInfo).subscribe(
     
      data => {
       
        console.log("emergencyCntInfo data is" + data);
      
        this.toaster.Success("Emergency Contact Details Saved")
       
    }

    );


  }
}
