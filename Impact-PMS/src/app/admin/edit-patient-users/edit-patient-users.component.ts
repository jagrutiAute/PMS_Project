import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';



import { AdminDashBoardService } from '../admin.service';
import { Patient } from '../patient';


@Component({
  selector: 'app-edit-patient-users',
  templateUrl: './edit-patient-users.component.html',
  styleUrls: ['./edit-patient-users.component.css']
})
export class EditPatientUsersComponent implements OnInit {


  id: number;
  patient: Patient;

  constructor(private route: ActivatedRoute,private router: Router,
    private adminDashBoardService: AdminDashBoardService) { }

  ngOnInit() {
    this.patient = new Patient();

    this.id = this.route.snapshot.params['id'];
    
    this.adminDashBoardService.getPatientById(this.id)
      .subscribe(data => {
        console.log(data)
      this.patient = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.adminDashBoardService.updatePatintById(this.id, this.patient)
      .subscribe(data => {
        console.log(data);
        this.patient = new Patient();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['admin-dashboard/patient-users']);
  }
}
