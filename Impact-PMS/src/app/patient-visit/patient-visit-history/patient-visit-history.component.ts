import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VisitHistoryServic } from '../visit-history.service';
import { VistihistoryDates } from './visithistroydates';

@Component({
  selector: 'app-patient-visit-history',
  templateUrl: './patient-visit-history.component.html',
  styleUrls: ['./patient-visit-history.component.css']
})
export class PatientVisitHistoryComponent implements OnInit {



  p: number = 1;
  constructor( private visithistoryservice:VisitHistoryServic, private router: Router) { }

  ngOnInit(): void {
    this.getvisithistory()

  }

    visithistory:VistihistoryDates[];

    getvisithistory(){
      let pid;
      if(sessionStorage.getItem('role')=='Physician'){
        pid = sessionStorage.getItem('pidforvisit')
      } else
      {
        pid = sessionStorage.getItem('mrnNumber')
      }
      this.visithistoryservice.getVisitHistoryDates(pid).subscribe(data=>{

          this.visithistory=data;
          console.log(data);


      })
    }


    getMedication(id: any){
   this.router.navigateByUrl('/app-body-layout/medication-history/'+id)
    }
}
