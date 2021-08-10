import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminDashBoardService } from '../admin.service';
import { HospitalUserService } from '../hospital-user.service';
import { HospitalUser } from '../HospitalUser';
import { Role } from '../role';
import { User } from '../user';

@Component({
  selector: 'app-create-hospital-user',
  templateUrl: './create-hospital-user.component.html',
  styleUrls: ['./create-hospital-user.component.css']
})
export class CreateHospitalUserComponent implements OnInit {

  maxDate: any;
  statusofEmployeeId: String;
  roles: Role[];

  constructor(private fb: FormBuilder,
    private router: Router,
    private service: HospitalUserService) { }

  ngOnInit(): void {
    this.futureDateDisable();
    this.service.getAllRoles().subscribe(
      (data) => {
        // console.log("data roles :::::  " + data)
        this.roles = data;

      },
      (error) => {
        console.log(error);
      }
    );
  }

  futureDateDisable() {
    var date: any = new Date();
    var todayDate: any = date.getDate();
    var month: any = date.getMonth();
    var year: any = date.getFullYear() - 18;
    if (todayDate < 10) {
      todayDate = '0' + todayDate;
    }
    if (month < 10) {
      month = '0' + month;
    }
    this.maxDate = year + "-" + month + "-" + todayDate;
    //this.maxDate=this.maxDate-100;

  }

  signUpFormProvider = this.fb.group({
    title: ['', Validators.required],
    firstName: ['',
      [Validators.required,
      Validators.minLength(2)
      ]
    ],
    lastName: ['',
      [Validators.required,
      Validators.minLength(2)
      ]],
    username: [
      '',
      [
        Validators.required,
        Validators.pattern('[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}')

      ]
    ],
    date_of_birth: ['', Validators.required],
    role: ['', Validators.required],
    employeeid: ['', Validators.required]
  });

  get f() {
    return this.signUpFormProvider.controls;
  }

  regProviderSubmit() {
    let user: User = new User();
    Object.assign(user, this.signUpFormProvider.value);
    //console.log("USers:::::: "+this.signUpFormProvider.get('username').value);
    // console.log("USers:::::: " + user.username);
    this.service.createHospitalUser(user).subscribe(
      (data) => {
        console.log("data is " + data);
        this.statusofEmployeeId = data;
        if (this.statusofEmployeeId === 'SUCCESS') {
          alert('registration successful');
          window.location.reload();
        }
        console.log("this.statusofEmployeeId  ::  " + this.statusofEmployeeId)
      },
      (error) => {
        console.log(error);
      }
    );
  }

  // submitForm() {
  //   let user: HospitalUser = new HospitalUser();
  //   Object.assign(user, this.userForm.value)
  //   this.service.createHospitalUser(user).subscribe(
  //     (data) => {
  //       console.log(data)
  //       alert("User Created Successfully...")
  //       this.router.navigateByUrl("/admin-dashboard/hospital-users")
  //     },
  //     (error) => {
  //       console.log(error)
  //     }
  //   )
  // }

}
