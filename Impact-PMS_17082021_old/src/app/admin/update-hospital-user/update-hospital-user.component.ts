import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { HospitalUserService } from '../hospital-user.service';
import { HospitalUser } from '../HospitalUser';

@Component({
  selector: 'app-update-hospital-user',
  templateUrl: './update-hospital-user.component.html',
  styleUrls: ['./update-hospital-user.component.css']
})
export class UpdateHospitalUserComponent implements OnInit {
  status: string[] = ["ACTIVE", "BLOCK", "INACTIVE"];

  employeeid: any
  huser: HospitalUser

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: HospitalUserService) { }

  ngOnInit(): void {
    this.huser = new HospitalUser()

    this.employeeid = this.route.snapshot.params['uid'];

    this.service.getHospitalUserById(this.employeeid).subscribe(
      (data) => {
        // console.log(data)
        this.huser = data
      },
      (error) => {
        console.log(error)
      }
    )
  }

  submitForm() {
    this.service.updateHospitalUserByUid(this.huser.user.id, this.huser.user.isActive).subscribe(
      (data) => {
        console.log("User updated succcessfully...")
        console.log(data)
        this.gotoList()
      },
      (error) => {
        console.log(error)
      }
    )
  }

  gotoList() {
    this.router.navigate(['admin-dashboard/hospital-users']);
  }

  // submitForm() {
  //   this.service.updateHospitalUser(this.id, this.user).subscribe((res) => {
  //     console.log(res)
  //     alert("User Updated Successfully...")
  //     this.router.navigateByUrl("/admin-dashboard/hospital-users")
  //   },
  //     (error) => {
  //       console.log(error)
  //     }
  //   )
  // }
}
