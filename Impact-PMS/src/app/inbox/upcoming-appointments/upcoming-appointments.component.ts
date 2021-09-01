import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Medication } from 'src/app/admin/medication-master';
import { MedicationService } from 'src/app/admin/medication.service';
import { SchedulingService } from 'src/app/admin/scheduling.service';
import { ScheduleDTO } from 'src/app/admin/scheduling/scheduledto';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { User1 } from 'src/app/user/user1';
import { UpcomingAppointmentDetails } from './upcomingapppoitments';

@Component({
  selector: 'app-upcoming-appointments',
  templateUrl: './upcoming-appointments.component.html',
  styleUrls: ['./upcoming-appointments.component.css']
})
export class UpcomingAppointmentsComponent implements OnInit {

  appoinmets: UpcomingAppointmentDetails[];
  user: User1;
  applno: any;
  p: number = 1;
 // patientsMedication: Medication[];
   map =new Map();
   finalMedication: Medication[];
  constructor(private toaster: ToasterService1,
    private router: Router, private schedulingservice:SchedulingService) {}

  ngOnInit() {
    this.reloadData();
    console.log("hello oye")

    
   // this.load();
  }

  reloadData() {
    this.schedulingservice.getallUpcomingAppointments().subscribe(x=>{
        console.log(this.appoinmets=x);

    })
    
  }

  // sorting
  key: string = 'id';
  reverse:boolean = false;
  sort(key: string){
     this.key = key;
     this.reverse = !this.reverse;
  }



  canceleAppoitment(apt:UpcomingAppointmentDetails){
          
      var tmp=new ScheduleDTO();
    //take phyid from session
     tmp.phid=apt.phyid;
      tmp.date=apt.date;
        tmp.time=apt.time;
      ///take patient id from drop down
      tmp.pid=apt.pid;
          this.schedulingservice.canceelapppoitment(tmp).subscribe(x=>{

                if(x=='Success'){
                    alert('Appoitment cancelled successfully');
                    location.reload();
                }
                else{
                    alert('You entered wrong data');
                }
                
          });

  }

   
  
}
