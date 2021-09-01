import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToasterService1 } from 'src/app/toaster-service.service';

import { Allergy } from '../allergy';
import { PatientDetailService } from '../patient.service';

@Component({
  selector: 'app-allergy-details',
  templateUrl: './allergy-details.component.html',
  styleUrls: ['./allergy-details.component.css']
})
export class AllergyDetailsComponent implements OnInit {

  allergies: Allergy[];

  finalAllergy: Allergy[];

  tmp: string;
  p: number = 1;
  map = new Map();
  name: any;


  count: number = 0;
  //button click function
  // changeText() {
  //   this.btnVal = "Added"
  // }

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service: PatientDetailService,
    private toaster: ToasterService1

  ) { }


  formAllergy = this.fb.group({
    status: ['', Validators.required],
  });




  getAllergy() {
    this.tmp = this.formAllergy.get('status').value;
    // console.log("Tmp :::::   " + this.tmp)
  }


  ngOnInit() {

    // if(localStorage.getItem('allergies').length != 0){
    //   this.allergies = JSON.parse(localStorage.getItem('allergies'));
    // }else{    

    this.service.getAllergyList().subscribe(

      (data) => {
        console.log("getAllergyList() :::::  " + data)

        this.allergies = data;
        localStorage.setItem('allergies', JSON.stringify(data));

      }
    );


    //  }





  }



  search() {
    if (this.name == "") {
      //this.reloadData();
    } else
      console.log("inside search else")
    this.allergies = this.allergies.filter(res => {
      return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
    })
  }


  addAllergy(allergy: Allergy) {

    if (this.map.has(allergy.id)) {
      this.toaster.Warning("already added")
      this.count = this.count + 1;

      console.log("count ::  " + this.count);

    } else {

      this.map.set(allergy.id, allergy)

      this.toaster.Success("allergy added")
    }


  }



  saveAllergy() {

    let r = confirm("are you sure to save? ")

    if (r == true) {


      let keys = Array.from(this.map.values());

      this.service.addAllergyPatient(keys).subscribe((data) => {
        data;
        console.log(data);

      },
        (error) => {
          console.log(error)

        })
      // this.router.navigate(['/app-body-layout/app-patient-allergy-details'])

      this.toaster.Success("Allegy saved")

      if (sessionStorage.getItem('role') == "Patient") {
        location.href = "/app-body-layout/app-patient-allergy-details";
      }

    } else {
      console.log("same page")
      this.toaster.Error("Allergies not saved")
      this.router.navigate(['/app-body-layout/allergy-details'])

    }



  }



  deleteAllergy(applNo: string) {
    this.map.delete(applNo)
  }



}
