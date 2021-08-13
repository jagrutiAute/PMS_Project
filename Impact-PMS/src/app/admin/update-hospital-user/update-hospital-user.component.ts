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
  status: string[] = ["Active", "Blocked", "Inactive"];

  id: number;
  user: HospitalUser[]

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: HospitalUserService) { }

  ngOnInit(): void {
    // this.user = new HospitalUser()

    this.id = this.route.snapshot.params['uid'];

    this.service.getHospitalUserById(this.id).subscribe(
      (data) => {
        console.log(data)
        this.user = data
      },
      (error) => {
        console.log(error)
      }
    )
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
