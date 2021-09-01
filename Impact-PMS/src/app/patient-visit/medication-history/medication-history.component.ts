import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MedicationService } from 'src/app/admin/medication.service';
import { Medication1 } from 'src/app/admin/medication1';

@Component({
  selector: 'app-medication-history',
  templateUrl: './medication-history.component.html',
  styleUrls: ['./medication-history.component.css']
})
export class MedicationHistoryComponent implements OnInit {


  medications: Medication1[];
  constructor(private medicationService: MedicationService, private route: ActivatedRoute){
    
  }
  ngOnInit() {
    console.log("date")
  
   this.route.params.subscribe(a => {
       console.log(a['id']);  
      });
    
    //this.reload();
 
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
