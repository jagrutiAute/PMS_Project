import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { AdminDashBoardService } from '../admin.service';
import { Procedure } from '../procedure';

@Component({
  selector: 'app-procedure',
  templateUrl: './procedure.component.html',
  styleUrls: ['./procedure.component.css']
})
export class ProcedureComponent implements OnInit {

procedure: Procedure[];
map = new Map();
count :number = 0;
p: number = 1;
procedureCode :any;

  constructor(private fb: FormBuilder,
    private router: Router,
    private service: AdminDashBoardService,
    private toaster: ToasterService1) { }


  

  ngOnInit(): void {

    this.service.getProcedureList().subscribe(

      (data) => {
        console.log("getProcedureList() :::::  " + data)

        this.procedure = data;

      }
    );
  }


  addProcedure(procedure: Procedure) {

    if (this.map.has(procedure.procedureCode)) {
      this.toaster.Warning("already added")
      this.count = this.count+1;

      console.log("count ::  "+this.count);
      
    } else{

      this.map.set(procedure.procedureCode, procedure)

      this.toaster.Success("procedure added")
    }
    
     
  }

  search() {
    if (this.procedureCode == "") {
      //this.reloadData();
    } else
      console.log("inside search else")
    this.procedureCode = this.procedureCode.filter((data: { procedureCode: string; }) => {
      return data.procedureCode.toLocaleLowerCase().match(this.procedureCode.toLocaleLowerCase());
    })
  }

  saveProcedure(){

    let r = confirm("are you sure to save? ")

    if (r == true) {


      let keys = Array.from(this.map.values());

      this.service.addProcedurePatient(keys).subscribe((data) => {
        data;
        console.log(data);
        
      },
        (error) => {
          console.log(error)
          
        })
     
    
     this.toaster.Success("Allegy saved")
     location.href = "physician-dashboard/procedure-details";
     

    } else {
      console.log("same page")
      this.toaster.Error("Allergies not saved")
      //this.router.navigate(['/app-body-layout/allergy-details'])
     
    }
  }

}
