import { ToasterService1 } from 'src/app/toaster-service.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Vital } from '../vital';
import { VitalSignsService } from '../vitalsigns.service';

@Component({
  selector: 'app-vital-signs',
  templateUrl: './vital-signs.component.html',
  styleUrls: ['./vital-signs.component.css']
})
export class VitalSignsComponent implements OnInit {

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service:VitalSignsService,
    private toaster: ToasterService1
  ) { }

  ngOnInit(): void {
  }

  vitalForm = this.fb.group({

    Height: ['', [Validators.required]],
    Weight: ['', [Validators.required]],
    Blood_Pressure: ['', [Validators.required]],
    Body_Temperature: ['', [Validators.required]],
    Respiration_Rate:['',[Validators.required]]
    

  });


  handleFormSubmit() {

    let vital: Vital = new Vital(165,57,90,36,72,"mi@gmail.com","mi@gmail.com");

    Object.assign(vital, this.vitalForm.value);

    this.service.addVitalSigns(vital).subscribe(
      data => {

        console.log("backent response " +data)
      this.toaster.Success("Vital Signs Added Successfully");
       // alert("successfully added vital signs" + data)
       
       

      },
      error => {
        console.log(error);
      }
    );
  }


  get f():any{
    return this.vitalForm.controls;
  }



}
