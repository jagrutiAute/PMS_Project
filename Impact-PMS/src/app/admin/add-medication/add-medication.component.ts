import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AdminDashBoardService } from '../admin.service';

@Component({
  selector: 'app-add-medication',
  templateUrl: './add-medication.component.html',
  styleUrls: ['./add-medication.component.css']
})
export class AddMedicationComponent  {

  //status: string[] = ["Active", "Blocked", "Disable"];

 /* medication: Medication = new Medication();
  submitted = false;

  constructor(private adminDashBoardService: AdminDashBoardService,
    private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.medication = new Medication();
  }

  save() {
    this.adminDashBoardService
    .addPatient(this.medication).subscribe(data => {
      console.log(data)
      this.medication = new Medication();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['medication/add-medication']);
  }  */
}
