import { Component, OnInit } from '@angular/core';
import { Diagnosis } from '../diagnosis';
import { DiagnosisService } from '../diagnosis.service';

@Component({
  selector: 'app-added-diagnosis',
  templateUrl: './added-diagnosis.component.html',
  styleUrls: ['./added-diagnosis.component.css']
})
export class AddedDiagnosisComponent implements OnInit {

  diagnosis: Diagnosis[];

  // pagination
  p: number = 1;
 
    map =new Map();

    // sorting
  key: string = 'id';
  reverse:boolean = false;
  sort(key: string){
     this.key = key;
     this.reverse = !this.reverse;
  }
  constructor(private diagnosisService: DiagnosisService) { }

  ngOnInit(): void {
    this.reload();
  }

  reload(){

    this.diagnosisService.getAddedDiagnosis().subscribe((data)=>{
      this.diagnosis = data;
    })
  }

  diagnosis_code: any;
  search(){
    if(this.diagnosis_code == ""){
      //this.reloadData();
    }else
    console.log("inside search else")
      this.diagnosis = this.diagnosis.filter(res=>{
      return res.diagnosis_code.toLocaleLowerCase().match(this.diagnosis_code.toLocaleLowerCase());
    }) 
  }

  deleteDiagnosis(diagnosis_code: string){
    this.map.delete(diagnosis_code)
  }

}
