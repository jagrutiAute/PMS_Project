import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { Medication } from '../admin-dashboard/medication-master';
import { MedicationService } from '../medication.service';

import { User1 } from '../user1';

@Component({
  selector: 'app-medication',
  templateUrl: './medication.component.html',
  styleUrls: ['./medication.component.css']
})
export class MedicationComponent implements OnInit {

  medications: Medication[];
  user: User1;
  applno: any;
  p: number = 1;
 // patientsMedication: Medication[];
   map =new Map();
   finalMedication: Medication[];
  constructor(private toaster: ToasterService1,
    private router: Router, private medicationService: MedicationService) {}

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
    console.log("hello")
    // for (let value of this.map.values()) {   
    //     //  this.finalMedication.push(value);
        
    //    console.log(value);  

    //   }

    let keys = Array.from( this.map.values());
   
    this.medicationService.addMedicationForPatient(keys).subscribe((data) =>{
      data;
      console.log(data);
    },
    (error) => {
      console.log(error)
    })
    

    this.router.navigate(['admin-dashboard/patient-details'])
  }
  else
  console.log("same page")
    
  }
}
