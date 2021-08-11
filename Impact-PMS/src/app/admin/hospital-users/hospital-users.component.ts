import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup } from '@angular/forms';
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

  // huser: HospitalUser

  id: any
  firstName: String

  // search: String

  // user: HospitalUser
  // form: FormGroup

  keyword1: String = "CT0001"

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private service: HospitalUserService
  ) { }

  ngOnInit(): void {
    this.reloadData();
    // this.searchNew()

    // this.user = new HospitalUser()

    // this.id = this.route.snapshot.params['uid'];

    // this.service.getHospitalUserById(this.id).subscribe(
    //   (data) => {
    //     console.log(data)
    //     this.user = data
    //   },
    //   (error) => {
    //     console.log(error)
    //   }
    // )
  }

  searchForm = new FormGroup({
    keyword: new FormControl()
  })

  onFormSubmit() {
    console.log(this.searchForm.value)
    console.log(this.searchForm.value['keyword'])
  }

  // form = new FormGroup({
  //   name: new FormControl()
  // });

  reloadData() {
    this.service.getAllHospitalUsers().subscribe(
      (data) => {
        this.husers = data
      },
      (error) => {
        console.log(error)
      }
    )
  }

  searchNew() {
    if (this.searchForm.value['keyword'].startsWith("CT")) {
      this.service.getHospitalUserById(this.searchForm.value['keyword']).subscribe(
        (data) => {
          console.log(data)
          this.husers = data
        },
        (error) => {
          console.log(error)
        }
      )
    } else {
      this.service.getHospitalUserByName(this.searchForm.value['keyword']).subscribe(
        (data) => {
          // console.log(data)
          this.husers = data
        },
        (error) => {
          console.log(error)
        }
      )
    }
  }

  search() {
    if (this.firstName = "") {
      console.log("Before ngOnInit...")
      this.reloadData();
      console.log("After ngOnInit...")
    } else {
      this.husers = this.husers.filter(res => {
        console.log(res)
        return res.firstName.toLocaleLowerCase().match(this.firstName.toLocaleLowerCase())
      })
    }
  }

  // getData(user: HospitalUser) {
  //   this.service.getHospitalUserById(user).subscribe(
  //     response => {
  //       this.user = response
  //     },
  //     error => {
  //       console.log("error while getting user Details");
  //     }
  //   );
  // }
  // searchForm = this.fb.group({
  //   searchfield:['']
  // })

  // searchForm(searchInfo) {
  //   this.user.employeeid = this.Name.value;
  //   this.getData(this.user);
  // }

  // get Name() {
  //   return this.form.get('name');
  // }

  updateUser(id: any) {
    this.router.navigate(['/admin-dashboard/hospital-users/update-user', id])
  }

  // updateUser1(id: number) {
  //   this.user = new HospitalUser()
  //   // this.id = this.route.snapshot.params['id'];

  //   this.service.getHospitalUserById(id).subscribe(
  //     (data) => {
  //       console.log(data)
  //       this.user = data
  //     },
  //     (error) => {
  //       console.log(error)
  //     }
  //   )
  // }

  // updateForm() {
  //   this.service.updateHospitalUser(this.user.employeeid, this.user).subscribe((res) => {
  //     console.log(res)
  //     alert("User Updated Successfully...")
  //     // this.router.navigateByUrl("/admin-dashboard/hospital-users")
  //     window.location.reload();
  //     // this.reloadData()
  //     // window.close()
  //   },
  //     (error) => {
  //       console.log(error)
  //     }
  //   )

  // }
}
