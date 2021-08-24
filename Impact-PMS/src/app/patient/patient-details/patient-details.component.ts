import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { Ethinicity } from '../ethinicity';
import { PatientDetailService } from '../patient.service';


import { PatientDetails } from '../patientDetail';
import { Race } from '../race';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {

   patientDetails: PatientDetails ;
    
   races:Race[];  
   ethinicities: Ethinicity[];
  
   username : string =  sessionStorage.getItem('username');

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service: PatientDetailService,
    private notifyService:ToasterService1

  ) { }

  ngOnInit() {
    
    this.service.getPatientDetails(this.username).subscribe(
      (data) => {
        console.log("getPatientDetails() :::::  " + data)
        this.patientDetails=data;
      
        sessionStorage.setItem('mrnNumber',''+this.patientDetails.mrnNumber);
       
       
      
      }
    );

    this.service.getAllRace().subscribe(
      (data) => {
        console.log("data Race :::::  " + data)
        this.races = data;

      },
      error => {
        console.log(error);
      }
    );

    this.service.getEthinicity().subscribe(
      (data) => {
        console.log("data Ethinicity :::::  " + data)
        this.ethinicities = data;

      },
      error => {
        console.log(error);
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


   

    let patientDetails: PatientDetails = new PatientDetails();

    this.patientDetails.mrnNumber= parseInt( sessionStorage.getItem('mrnNumber'));
    
    Object.assign(this.patientDetails, this.patientDetailsForm.value);
    console.log("above subscribe");
    this.service.updatePatientDetails(this.patientDetails).subscribe(
     
      
      data => {
       
        sessionStorage.setItem('patient', JSON.stringify( this.patientDetails)); 
        console.log("patientDetails data is" + data);
      
       
    }    

    );


  }


  showToasterSuccess(){
    this.notifyService.Success("Data shown successfully !!", "ItSolutionStuff.com")
}

  
}
    