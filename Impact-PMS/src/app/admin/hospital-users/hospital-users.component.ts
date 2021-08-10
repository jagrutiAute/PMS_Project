import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HospitalUserService } from '../hospital-user.service';
import { HospitalUser } from '../HospitalUser';

@Component({
  selector: 'app-hospital-users',
  templateUrl: './hospital-users.component.html',
  styleUrls: ['./hospital-users.component.css']
})
export class HospitalUsersComponent implements OnInit {

  husers: HospitalUser[];

  id: any
  user: HospitalUser

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: HospitalUserService
  ) { }

  ngOnInit(): void {
    this.reloadData();

    this.user = new HospitalUser()

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

  reloadData() {
    this.service.getAllHospitalUsers().subscribe(
      (data) => {
        this.husers = data
        console.log(this.husers)
      },
      (error) => {
        console.log(error)
      }
    )
  }

  updateUser(id: any) {
    this.router.navigate(['/admin-dashboard/hospital-users/update-user', id])
  }

  updateUser1(id: number) {
    this.user = new HospitalUser()
    // this.id = this.route.snapshot.params['id'];

    this.service.getHospitalUserById(id).subscribe(
      (data) => {
        console.log(data)
        this.user = data
      },
      (error) => {
        console.log(error)
      }
    )
  }

  updateForm() {
    this.service.updateHospitalUser(this.user.employeeid, this.user).subscribe((res) => {
      console.log(res)
      alert("User Updated Successfully...")
      // this.router.navigateByUrl("/admin-dashboard/hospital-users")
      window.location.reload();
      // this.reloadData()
      // window.close()
    },
      (error) => {
        console.log(error)
      }
    )

  }

  deleteUser(id: any) {
    this.service.deleteHospitalUser(id).subscribe(
      res => {
        // this.users = this.users.filter(user => user.id !== id);
        alert('User deleted successfully...');
        console.log(res);
        this.reloadData();
      },
      (error) => {
        console.log(error)
      }
    )
  }

}
