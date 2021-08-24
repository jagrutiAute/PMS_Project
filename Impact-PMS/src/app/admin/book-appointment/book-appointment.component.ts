import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetSchedule } from '../getSchedule';
import { Schedule1 } from '../schedule1';
import { ScheduleBook } from '../schedulebook';
import { Scheduling } from '../scheduling';
import { SchedulingService } from '../scheduling.service';


@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css']
})
export class BookAppointmentComponent implements OnInit {

  //scheduling: Scheduling[];
  //str:string;
  schedule: Schedule1[];
  // user: User1;
   //firstName: any;
   p: number = 1;
  // getSchedule:GetSchedule
   constructor(private schedulingService: SchedulingService,
     private router: Router) {}
 
   ngOnInit() {
     this.reloadData();
     console.log("hello oye")
    // this.load();
   }
 // load(){
 //   console.log("load")
 //   //this.patients.forEach(projet=>console.log(projet.id));
 //   for(var pat in this.patients){
 //     console.log("hello")
 //     console.log(this.patients[pat]);
 //   }
 // }
   reloadData() {
     let getSchedule = new GetSchedule();
  //  let getschedule = new Patient1();
      getSchedule.phyid="11";
      getSchedule.date="2021-08-17";
      this.schedulingService.getAllUnbookedappointmet(getSchedule).subscribe((data) => {
       this.schedule = data;
       console.log(data)
     // location.reload();
     /*  for(let data in this.patients){
         this.patients[data];
         console.log("hello")
         console.log(this.patients[data])
         for(let d in this.patients[data]){
           d.match("user")
           console.log(d)
         }
 
       } */
      // console.log(this.scheduling)
       
     },
     (error) => {
       console.log(error)
     })
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
     let date1: Date = new Date("2021-08-17");
     scheduleBook.phid = "11";
     scheduleBook.time = time;
     scheduleBook.date = date1;
    
     scheduleBook.pid = "1";
  
     this.schedulingService.bookappointment(scheduleBook).subscribe((data)=>{
     // location.reload();
    if(data=="booked"){
     location.reload();
    }
     })
   }
 
   updateStatus(id: number){
     this.router.navigate(['admin-dashboard/patient-users/edit-patient-users', id]);
   }

}
