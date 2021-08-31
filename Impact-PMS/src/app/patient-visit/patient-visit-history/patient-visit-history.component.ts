import { Component, OnInit } from '@angular/core';
import { VisitHistoryServic } from '../visit-history.service';
import { VistihistoryDates } from './visithistroydates';

@Component({
  selector: 'app-patient-visit-history',
  templateUrl: './patient-visit-history.component.html',
  styleUrls: ['./patient-visit-history.component.css']
})
export class PatientVisitHistoryComponent implements OnInit {

  constructor( private visithistoryservice:VisitHistoryServic) { }

  ngOnInit(): void {
    this.getvisithistory()

  }

    visithistory:VistihistoryDates[];

    getvisithistory(){
      this.visithistoryservice.getVisitHistoryDates('11').subscribe(data=>{

          this.visithistory=data;
          console.log(data);


      })
    }

}
