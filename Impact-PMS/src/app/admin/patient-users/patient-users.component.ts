import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AdminDashBoardService } from '../admin.service';
import { Patient } from '../patient';
import { User1 } from '../user1';





@Component({
  selector: 'app-patient-users',
  templateUrl: './patient-users.component.html',
  styleUrls: ['./patient-users.component.css']
})
export class PatientUsersComponent implements OnInit {

 // patients: Observable<Patient[]>;
  patients: Patient[];
  user: User1;
  firstName: any;
  p: number = 1;
  constructor(private adminDashBoardService: AdminDashBoardService,
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
     this.adminDashBoardService.getPatient1().subscribe((data1) => {
      this.patients= data1
      console.log(data1)
    /*  for(let data in this.patients){
        this.patients[data];
        console.log("hello")
        console.log(this.patients[data])
        for(let d in this.patients[data]){
          d.match("user")
          console.log(d)
        }

      } */
      console.log(this.patients)
      
    },
    (error) => {
      console.log(error)
    })
    // console.log(this.patients);
  }


  search(){
    if(this.firstName == ""){
      this.reloadData();
    }else
      this.patients = this.patients.filter(res=>{
      return res.firstName.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase());
    }) 
  }

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

  updatePatient(id: number){
    this.router.navigate(['admin-dashboard/patient-users/edit-patient-users', id]);
  }
}
