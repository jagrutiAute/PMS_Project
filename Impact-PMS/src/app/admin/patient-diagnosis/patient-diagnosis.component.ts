import { Component, OnInit } from '@angular/core';
import { Diagnosis } from '../diagnosis';
import { DiagnosisService } from '../diagnosis.service';
import { MedicationService } from '../medication.service';

@Component({
  selector: 'app-patient-diagnosis',
  templateUrl: './patient-diagnosis.component.html',
  styleUrls: ['./patient-diagnosis.component.css']
})
export class PatientDiagnosisComponent implements OnInit {

  diagnosis: Diagnosis[];
  constructor(private diagnosisService: DiagnosisService){}
  

  ngOnInit(): void {
    this.reload();
  }

  reload(){

    this.diagnosisService.getAddedDiagnosis().subscribe((data)=>{
      this.diagnosis=data;
      console.log("inside patient-details: reload")
      console.log(data)
    },
    (error)=>{
      console.log(error)
    })
   }

}
