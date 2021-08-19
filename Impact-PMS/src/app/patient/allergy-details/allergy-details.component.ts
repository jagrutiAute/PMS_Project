import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { Allergy } from '../allergy';
import { PatientDetailService } from '../patient.service';

@Component({
  selector: 'app-allergy-details',
  templateUrl: './allergy-details.component.html',
  styleUrls: ['./allergy-details.component.css']
})
export class AllergyDetailsComponent implements OnInit {

  allergies: Allergy[];

  tmp:string;
  p: number = 1;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service: PatientDetailService,


  ) { }


  formAllergy = this.fb.group({
    status: ['', Validators.required],
    });
  
  
    

    getAllergy(){
      this.tmp = this.formAllergy.get('status').value;
      console.log("Tmp :::::   "+this.tmp)
    }
  

 ngOnInit() {

  
  this.service.getAllergyList().subscribe(

    (data) => {
      console.log("getAllergyList() :::::  " + data)
      localStorage.setItem('allergyList',''+data);
      this.allergies = data;
            
    }
  );

 }


 
  
 




}
