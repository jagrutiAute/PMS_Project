import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MedicationService } from 'src/app/admin/medication.service';
import { Medication1 } from 'src/app/admin/medication1';
import { VisitHistoryServic } from '../visit-history.service';

@Component({
  selector: 'app-medication-history',
  templateUrl: './medication-history.component.html',
  styleUrls: ['./medication-history.component.css']
})
export class MedicationHistoryComponent implements OnInit {

 date: any;
  medications: Medication1[];
  constructor(private medicationService: MedicationService, private route: ActivatedRoute, private visitHistoryService: VisitHistoryServic){
    
  }
  ngOnInit() {
    console.log("date")
  
   this.route.params.subscribe(a => {
    this.date = a['id'];
        
      });
    
    this.reload();
 
  }

  reload(){
  
    this.visitHistoryService.getMedicationforSpecificDate(this.date).subscribe((data)=>{
      this.medications=data;
      console.log("inside patient-details: reload")
      //location.reload();
      console.log(data)
    },
    (error)=>{
      console.log(error)
    })
   }

   downloadMedication(){

    this.visitHistoryService.downloadMedication(this.date).subscribe((data) =>{
       data;
       var newBlob = new Blob([data], { type: "application/pdf" });
       //const data1 = window.URL.createObjectURL(newBlob);

       if (window.navigator && window.navigator.msSaveOrOpenBlob) {
        window.navigator.msSaveOrOpenBlob(newBlob);
        return;
    }
    
    // For other browsers: 
    // Create a link pointing to the ObjectURL containing the blob.
    const data1 = window.URL.createObjectURL(newBlob);
    window.open(data1)
    //const link = document.createElement('a');
   
    })
   }


 
}
