import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminDashBoardService } from '../admin.service';
import { GetSchedule } from '../getSchedule';
import { Patient } from '../patient';
import { Scheduling } from '../scheduling';
import { SchedulingService } from '../scheduling.service';
import { User1 } from '../user1';

@Component({
  selector: 'app-scheduling',
  templateUrl: './scheduling.component.html',
  styleUrls: ['./scheduling.component.css']
})
export class SchedulingComponent implements OnInit {
 scheduling: Scheduling[];
 //str:string;
 //getScheduling: GetSchedule;
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
    let d: Date = new Date("2021-08-17");
     getSchedule.phyid="11";
     getSchedule.date=d;
     this.schedulingService.getAllUnbookedappointmet(getSchedule).subscribe((data) => {
      this.scheduling = data;

      console.log(data)
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

  updateStatus(id: number){
    this.router.navigate(['admin-dashboard/patient-users/edit-patient-users', id]);
  }

}
