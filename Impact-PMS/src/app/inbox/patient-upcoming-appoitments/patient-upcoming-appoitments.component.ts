import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SchedulingService } from 'src/app/admin/scheduling.service';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { User1 } from 'src/app/user/user1';
import { UpcomingAppointmentDetails } from '../upcoming-appointments/upcomingapppoitments';

@Component({
  selector: 'app-patient-upcoming-appoitments',
  templateUrl: './patient-upcoming-appoitments.component.html',
  styleUrls: ['./patient-upcoming-appoitments.component.css']
})
export class PatientUpcomingAppoitmentsComponent implements OnInit {

  constructor(private toaster: ToasterService1,
    private router: Router, private schedulingservice:SchedulingService) {}


  ngOnInit(): void {
    this.reloadData();
  }

  appoinmets: UpcomingAppointmentDetails[];
  user: User1;
  applno: any;
  p: number = 1;
 // patientsMedication: Medication[];
   map =new Map();
   //finalMedication: Medication[];

 

  reloadData() {
    this.schedulingservice.getallUpcomingAppointmentsforpatient().subscribe(x=>{
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




}
