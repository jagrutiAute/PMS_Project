import { ToasterService1 } from 'src/app/toaster-service.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Vital } from '../vital';
import { VitalSignsService } from '../vitalsigns.service';
import { PatientIdAndName } from '../patientId';
import { stringify } from '@angular/compiler/src/util';

@Component({
  selector: 'app-vital-signs',
  templateUrl: './vital-signs.component.html',
  styleUrls: ['./vital-signs.component.css']
})
export class VitalSignsComponent implements OnInit {

   vital:Vital;
  // patientID:any;
   patientIdAndName: PatientIdAndName[] ;
   selectoption: any;
   roles:string= sessionStorage.getItem('role');

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service:VitalSignsService,
    private toaster: ToasterService1
  ) { }

  ngOnInit(): void {


    this.service.getAllPatientIdAndName().subscribe((data)=>{
      this.patientIdAndName = data;
      console.log("hiiiiiiiiiiiii")
      console.log(data);
    });
   

  }

  vitalForm = this.fb.group({

    Height: ['', [Validators.required]],
    Weight: ['', [Validators.required]],
    Blood_Pressure: ['', [Validators.required]],
    Body_Temperature: ['', [Validators.required]],
    Respiration_Rate:['',[Validators.required]],
    patientID:['',[Validators.required]]

  });


  handleFormSubmit() {

   
   let vital: Vital = new Vital();
    //Object.assign(vital, );
    vital.bloodPressure=this.vitalForm.value.Blood_Pressure;
    vital.bodyTemperature=this.vitalForm.value.Body_Temperature;
    vital.height=this.vitalForm.value.Height;
    vital.weight=this.vitalForm.value.Weight;
    vital.respirationRate=this.vitalForm.value.Respiration_Rate;
   vital.mrnNumebr = Number(sessionStorage.getItem('selectOption'));
   //vital.mrnNumebr =  22;

   console.log("+++++"+vital)
    //Object.assign(vital,this.vitalForm.value)

    console.log(vital.mrnNumebr);
   
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


  reloadData() {
    let getPatientId = new PatientIdAndName();
     

        let pid = this.selectoption;
        this.service.fetchVitalSigns("1").subscribe(
          data => {
    
            this.vital = data; 
           console.log("vital Sign Fetch ....."+data)
    
          },
          error => {
            console.log(error);
          }
        );
      
      

  }
 


    selectOption(event: any) {
   //console.log(event)
    //console.log("value")
    this.selectoption = event.target.value;
    console.log("event.target.value ::  "+event.target.value)

    sessionStorage.setItem('selectOption',this.selectoption);
    this.reloadData();


   
    // this.schedulingService.getPhysicianNameById(this.selectoption).subscribe((data)=>{
    //   this.physicianName = data;
    //   console.log("patietName")
    //   console.log(this.physicianName);
    // })
   
    }

}
