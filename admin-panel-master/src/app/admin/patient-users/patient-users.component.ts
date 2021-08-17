import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AdminDashBoardService } from '../admin.service';
import { Patient } from '../patient';

@Component({
  selector: 'app-patient-users',
  templateUrl: './patient-users.component.html',
  styleUrls: ['./patient-users.component.css']
})
export class PatientUsersComponent implements OnInit {

  patients: Observable<Patient[]>;

  constructor(private adminDashBoardService: AdminDashBoardService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.patients = this.adminDashBoardService.getPatient();
  }

  deletePatient(id: number) {
    this.adminDashBoardService.deleteEmployee(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  // employeeDetails(id: number){
  //   this.router.navigate(['details', id]);
  // }

  updatePatient(id: number){
    this.router.navigate(['admin-dashboard/patient-users/edit-patient-users', id]);
  }
}
