import { Component, OnInit } from '@angular/core';
import { COMPOSITION_BUFFER_MODE } from '@angular/forms';
import { Router } from '@angular/router';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { Medication } from '../admin-dashboard/medication-master';
import { AdminDashBoardService } from '../admin.service';

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
  patientsMedication: Medication[];
   map =new Map();
  constructor(private medicationService: AdminDashBoardService, private toaster: ToasterService1,
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
    console.log("inside reload")
     this.medicationService.gerMedication().subscribe((data1) => {
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
      //this.reloadData();
    }else
    console.log("inside search else")
      this.medications = this.medications.filter(res=>{
      return res.applNo.toLocaleLowerCase().match(this.applno.toLocaleLowerCase());
    }) 
  }

  // sorting
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

  
  addMedication(medication: Medication){
    //this.router.navigate(['admin-dashboard/patient-users/edit-patient-users', id]);
   if(this.map.has(medication.applNo)){
    this.toaster.Warning("already added")

   } else
  
    this.map.set(medication.applNo, medication)

    // getPatientIdFromSession
  }

  
  deleteMedication(applNo: string){
    this.map.delete(applNo)
  }


   // saveMedication
  saveMedication(){
  let r =  confirm("are you sure to save? ")

  if(r==true){
    this.router.navigate(['admin-dashboard/patient-users'])
  }else
  console.log("same page")
    
  }
}
