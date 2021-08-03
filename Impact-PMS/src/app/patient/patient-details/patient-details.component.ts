import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PatientDetailService } from '../patient.service';


import { PatientDetails } from '../patientDetail';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {

  

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service: PatientDetailService

  ) { }

  ngOnInit() {
    
    this.service.getPatientDetails().subscribe(
      (data) => {
        console.log("getPatientDetails() :::::  " + data)
        
      }
    );
  }


  patientDetailsForm = this.fb.group({

    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    dateOfBirth: ['', Validators.required],
    age: ['', Validators.required],
    gender: ['', Validators.required],
    languageKnown: ['', Validators.required],
    race: ['', Validators.required],
    ethinicity: ['', Validators.required],
    email: ['', Validators.required],
    homeAddress: ['', Validators.required],
    contactNumber: ['', Validators.required]

  });

  get f() {
    return this.patientDetailsForm.controls;
  }

  updatePatientDetails() {

    console.log("inside method");

    let patientDetails: PatientDetails = new PatientDetails();

    Object.assign(patientDetails, this.patientDetailsForm.value);
    console.log("above subscribe");
    this.service.updatePatientDetails(patientDetails).subscribe(
     
      data => {
       
        console.log("patientDetails data is" + data);
      
       
    }

    );


  }

}
    