import { Component, OnInit } from '@angular/core';
import { SchedulingService } from 'src/app/admin/scheduling.service';
import { Cancelappointments } from '../cancelappoitment';

@Component({
  selector: 'app-cancelappointments',
  templateUrl: './cancelappointments.component.html',
  styleUrls: ['./cancelappointments.component.css']
})
export class CancelappointmentsComponent implements OnInit {

  constructor(private schedulingservice:SchedulingService) { }

  ngOnInit(): void {
    this.getallcancelledappimtnets();
  }

    cancealappoitmentsresult:Cancelappointments[];


    getallcancelledappimtnets(){
        //get pateient id from session
        let username= sessionStorage.getItem('mrnNumber');
        this.schedulingservice.getAllCancelAppoitmetns(username).subscribe(data=>{
            this.cancealappoitmentsresult=data;
            console.log(data);

        });
    }
}
