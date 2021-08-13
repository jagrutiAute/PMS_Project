import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Medication } from '../admin-dashboard/medication-master';
import { AdminDashBoardService } from '../admin.service';
import { Patient } from '../patient';
import { User1 } from '../user1';

@Component({
  selector: 'app-medication',
  templateUrl: './medication.component.html',
  styleUrls: ['./medication.component.css']
})
export class MedicationComponent implements OnInit {

 // patients: Patient[];
  medications: Medication[];
  user: User1;
  applno: any;
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
     this.adminDashBoardService.gerMedication().subscribe((data1) => {
      this.medications= data1
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
      console.log(this.medications)
      
    },
    (error) => {
      console.log(error)
    })
    // console.log(this.patients);
  }


  search(){
    if(this.applno == ""){
      this.reloadData();
    }else
      this.medications = this.medications.filter(res=>{
      return res.applNo.toLocaleLowerCase().match(this.applno.toLocaleLowerCase());
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
