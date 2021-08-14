import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


import { AdminDashBoardService } from '../admin.service';
import { Patient } from '../patient';


@Component({
  selector: 'app-add-patient-users',
  templateUrl: './add-patient-users.component.html',
  styleUrls: ['./add-patient-users.component.css']
})
export class AddPatientUsersComponent implements OnInit {

  status: string[] = ["Active", "Blocked", "Disable"];

  patient: Patient = new Patient();
  submitted = false;

  constructor(private adminDashBoardService: AdminDashBoardService,
    private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.patient = new Patient();
  }

  save() {
    this.adminDashBoardService
    .addPatient(this.patient).subscribe(data => {
      console.log(data)
      this.patient = new Patient();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['admin-dashboard/patient-users']);
  }
}
