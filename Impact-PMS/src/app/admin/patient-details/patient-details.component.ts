import {Component, OnInit} from '@angular/core';
import { MedicationService } from '../medication.service';
import { Medication1 } from '../medication1';



@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {
  
  medications: Medication1[];
  constructor(private medicationService: MedicationService){}
  ngOnInit() {
    this.reload();
    
  }

  

 reload(){

  this.medicationService.getAddedMedication().subscribe((data)=>{
    this.medications=data;
    console.log("inside patient-details: reload")
    console.log(data)
  },
  (error)=>{
    console.log(error)
  })
 }
}
