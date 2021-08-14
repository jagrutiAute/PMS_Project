import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmergencyContactInfo } from '../emergencyContactInfo';
import { PatientDetailService } from '../patient.service';

@Component({
  selector: 'app-emergency-contact-info',
  templateUrl: './emergency-contact-info.component.html',
  styleUrls: ['./emergency-contact-info.component.css']
})
export class EmergencyContactInfoComponent implements OnInit {

  emergencyContactInfo: EmergencyContactInfo;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service: PatientDetailService

  ) { }

  ngOnInit(): void {

    this.service.getPatientEmergencyCntDetails().subscribe(
      (data) => {
        console.log("getPatientEmergencyCntDetails() :::::  " + data)
        this.emergencyContactInfo=data;

        
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

   // this.patientDetails.mrnNumber=1;
    
    Object.assign(emergencyCntInfo, this.emergencyCntInfo.value);
    
    this.service.updateEmergencyCntDetails(emergencyCntInfo).subscribe(
     
      data => {
       
        console.log("emergencyCntInfo data is" + data);
      
       
    }

    );


  }
}
