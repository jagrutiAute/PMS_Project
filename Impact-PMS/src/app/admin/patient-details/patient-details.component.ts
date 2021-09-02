import {Component, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NbWindowService } from '@nebular/theme';
import { MedicationService } from '../medication.service';
import { Medication1 } from '../medication1';



@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent1 implements OnInit {
  
  medications: Medication1[];
  constructor(private medicationService: MedicationService){
    
  }
  ngOnInit() {
    console.log("date")
    
    this.reload();
 
  }

  

 reload(){
  
  this.medicationService.getAddedMedication().subscribe((data)=>{
    this.medications=data;
    console.log("inside patient-details: reload")
    //location.reload();
    console.log(data)
  },
  (error)=>{
    console.log(error)
  })
 }
}
