import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetSchedule } from '../getSchedule';
import {PhysicianIdAndName } from '../physicianId';
import { PhysicianName } from '../physicianName';

import { Schedule1 } from '../schedule1';
import { ScheduleBook } from '../schedulebook';
import { SchedulingService } from '../scheduling.service';


@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css']
})
export class BookAppointmentComponent implements OnInit {

  //scheduling: Scheduling[];
  //str:string;
  physicianIdAndName: PhysicianIdAndName[];
 // physicianName: PhysicianName[];
  schedule: Schedule1[];
  // user: User1;
   //firstName: any;
   p: number = 1;
  // getSchedule:GetSchedule

  tempDate: Date;
  selectoption: any;
   constructor(private schedulingService: SchedulingService,
     private router: Router) {}
 
   ngOnInit() {
     this.reloadData();
     console.log("hello oye")
    // this.load();
    this.schedulingService.getAllPhysicianIdAndName().subscribe((data)=>{
      this.physicianIdAndName = data;
      console.log("hiiiiiiiiiiiii")
      console.log(data);
    })
    console.log("out")

    
    
   }
 
   reloadData() {
     let getSchedule = new GetSchedule();
     //  let getschedule = new Patient1();
     //let d: Date = new Date("2021-08-17");
     // getSchedule.phyid="CT0003";
      getSchedule.phyid= this.selectoption;
      console.log(getSchedule.phyid)

      getSchedule.date = this.tempDate;
      console.log(getSchedule.date)

      console.log("inside reload")
      console.log(this.tempDate);
      if(getSchedule.phyid!=null && getSchedule.date!=null){
      this.schedulingService.getAllUnbookedappointmet(getSchedule).subscribe((data) => {
       this.schedule = data;
       console.log(data)
    
       
     },
     (error) => {
       console.log(error)
     })
    }
     // console.log(this.patients);
   }
 
 
   // search(){
   //   if(this.firstName == ""){
   //     this.reloadData();
   //   }else
   //     this.patients = this.patients.filter(res=>{
   //     return res.firstName.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase());
   //   }) 
   // }
 
   key: string = 'id';
   reverse:boolean = false;
   sort(key: string){
      this.key = key;
      this.reverse = !this.reverse;
   }
  /* deletePatient(id: number) {
     this.adminDashBoardService.deleteEmployee(id)
       .subscribe(
         data => {
           console.log(data);
           this.reloadData();
         },
         error => console.log(error));
   }*/
 
   // employeeDetails(id: number){
   //   this.router.navigate(['details', id]);
   // }
   
   bookappointment(time: string){
     // get Physician is from dropdown 
     // get date from date picker
     // get patient id from session
     
     let scheduleBook = new ScheduleBook();
     //let date1: Date = new Date("2021-08-17");
    // scheduleBook.phid = "CT0003";
     scheduleBook.phid =this.selectoption;
     scheduleBook.time = time;
     scheduleBook.date = this.tempDate;
    
     scheduleBook.pid = "5";
  
     this.schedulingService.bookappointment(scheduleBook).subscribe((data)=>{
     // location.reload();
    if(data=="booked"){
     location.reload();
    }
     })
   }

   
   onChangeEvent(event:any){
    console.log(event);
    this.tempDate = event.target.value;
    console.log(event.target.value);
    this.reloadData();
    //location.reload();
    }

    selectOption(event: any) {
    //console.log(event)
    //console.log("value")
    this.selectoption = event.target.value;
    console.log(event.target.value)
    this.reloadData();

    // this.schedulingService.getPhysicianNameById(this.selectoption).subscribe((data)=>{
    //   this.physicianName = data;
    //   console.log("patietName")
    //   console.log(this.physicianName);
    // })
   
    }

    
 
   updateStatus(id: number){
     this.router.navigate(['admin-dashboard/patient-users/edit-patient-users', id]);
   }

}
