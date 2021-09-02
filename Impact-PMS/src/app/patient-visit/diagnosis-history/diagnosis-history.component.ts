import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Diagnosis } from 'src/app/admin/diagnosis';
import { DiagnosisService } from 'src/app/admin/diagnosis.service';

@Component({
  selector: 'app-diagnosis-history',
  templateUrl: './diagnosis-history.component.html',
  styleUrls: ['./diagnosis-history.component.css']
})
export class DiagnosisHistoryComponent implements OnInit {

  diagnosis: Diagnosis[];
  date: any;
  constructor(private diagnosisService: DiagnosisService, private route: ActivatedRoute){}
  

  ngOnInit(): void {
    this.route.params.subscribe(a => {
      this.date = a['id'];
          
        });
    this.reload();
  }

  reload(){

    this.diagnosisService.getdiagnosisforspecificdate(this.date).subscribe((data)=>{
      this.diagnosis=data;
      console.log("inside patient-details: reload")
      console.log(data)
    },
    (error)=>{
      console.log(error)
    })
   }

   downloadDiagnosis(){
     
   }
}
