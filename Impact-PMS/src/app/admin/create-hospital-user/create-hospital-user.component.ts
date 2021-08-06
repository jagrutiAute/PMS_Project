import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminDashBoardService } from '../admin.service';
import { HospitalUserService } from '../hospital-user.service';
import { HospitalUser } from '../HospitalUser';

@Component({
  selector: 'app-create-hospital-user',
  templateUrl: './create-hospital-user.component.html',
  styleUrls: ['./create-hospital-user.component.css']
})
export class CreateHospitalUserComponent implements OnInit {

  status: string[] = ["Active", "Blocked", "Inactive"];

  userForm: FormGroup

  constructor(private fb: FormBuilder, private router: Router, private service: HospitalUserService) { }

  ngOnInit(): void {
    this.userForm = this.fb.group(
      {
        id: [''],
        firstName: [''],
        lastName: [''],
        dateOfJoining: [''],
        status: [''],
      }
    )
  }

  submitForm() {
    let user: HospitalUser = new HospitalUser();
    Object.assign(user, this.userForm.value)
    this.service.createHospitalUser(user).subscribe(
      (data) => {
        console.log(data)
        alert("User Created Successfully...")
        this.router.navigateByUrl("/admin-dashboard/hospital-users")
      },
      (error) => {
        console.log(error)
      }
    )
  }

}
