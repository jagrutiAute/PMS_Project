import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { AdminDashBoardService } from '../admin.service';
import { Diagnosis } from '../diagnosis';
import { DiagnosisService } from '../diagnosis.service';


@Component({
  selector: 'app-diagnosis',
  templateUrl: './diagnosis.component.html',
  styleUrls: ['./diagnosis.component.css']
})
export class DiagnosisComponent implements OnInit {

  //medications: Medication[];
  diagnosis: Diagnosis[];
  //user: User1;
 // applno: any;
 diagnosis_code: any;
  p: number = 1;
 // patientsMedication: Medication[];
   map =new Map();
   //finalMedication: Medication[];
  constructor(private toaster: ToasterService1,
    private router: Router, private diagnosisService: DiagnosisService) {}

  ngOnInit() {
    this.reloadData();
    console.log("hello oye")
   
  }

  reloadData() {
    console.log("inside reload")
    if(localStorage.getItem('diagnosis') == null){

      this.diagnosisService.getDiagnosis().subscribe((data1) => {
        this.diagnosis= data1
        localStorage.setItem('diagnosis',JSON.stringify(data1))
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
        console.log(this.diagnosis)
        
      },
      (error) => {
        console.log(error)
      })
      // console.log(this.patients);
    }else{
      this.diagnosis = JSON.parse(localStorage.getItem('diagnosis'));
    }
    }
    


  search(){
    if(this.diagnosis_code == ""){
      //this.reloadData();
    }else
    console.log("inside search else")
      this.diagnosis = this.diagnosis.filter(res=>{
      return res.diagnosis_code.toLocaleLowerCase().match(this.diagnosis_code.toLocaleLowerCase());
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

  // add Diagnosis for patient
  addDiagnosis(diagnosis: Diagnosis){

   if(this.map.has(diagnosis.diagnosis_code)){
    //this.toaster.Warning("already added")
     alert("Already you have added")
   } else
  
    this.map.set(diagnosis.diagnosis_code, diagnosis)

  
  }

  
  deleteDiagnosis(diagnosis_code: string){
    this.map.delete(diagnosis_code)
  }


   // saveDiagnosis
  saveDiagnosis(){
  let r =  confirm("are you sure to save? ")

  if(r==true){
    console.log("hello")


    let keys = Array.from( this.map.values());
   
    this.diagnosisService.addDiagnosisForPatient(keys).subscribe((data) =>{
      data;
      console.log(data);
    },
    (error) => {
      console.log(error)
    })
    

    this.router.navigate(['physician-dashboard/patient-diagnosis'])
  }
  else
  //console.log("same page")
    alert("not save diagnosis")
  }

}
