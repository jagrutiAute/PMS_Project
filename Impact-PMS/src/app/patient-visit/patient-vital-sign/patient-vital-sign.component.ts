import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { PatientIdAndName } from '../patientId';
import { Vital } from '../vital';
import { VitalSignsService } from '../vitalsigns.service';

@Component({
  selector: 'app-patient-vital-sign',
  templateUrl: './patient-vital-sign.component.html',
  styleUrls: ['./patient-vital-sign.component.css']
})
export class PatientVitalSignComponent implements OnInit {

  vital:Vital;
  patientIdAndName: PatientIdAndName[] ;
  selectoption: any;
  roles:string= sessionStorage.getItem('role');

  constructor( private fb: FormBuilder,
    private router: Router,
    private service:VitalSignsService,
    private toaster: ToasterService1) { }

  ngOnInit(): void {

    this.service.getAllPatientIdAndName().subscribe((data)=>{
      this.patientIdAndName = data;
      console.log("hiiiiiiiiiiiii")
      console.log(data);
    });

    let pid = sessionStorage.getItem('mrnNumber')
    this.service.fetchVitalSigns(pid).subscribe(
      data => {

        this.vital = data; 
       console.log("vital Sign Fetch ....."+data)

      },
      error => {
        console.log(error);
      }
    );
  }

}
