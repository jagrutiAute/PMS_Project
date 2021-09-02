import { NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { Login } from 'src/app/Login';
import { PatientDetails } from 'src/app/patient/patientDetail';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { LoginService } from '../login.service';
import { User } from '../user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  passwordFlag: boolean = false;
  emailFlag: boolean = false;

  user: User;

  attempts: number;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    // private service: LoginService
    private service: AuthService,
    private toaster: ToasterService1
  ) { }




  signUpForm = this.fb.group({

    email: [
      '',
      [
        Validators.required,
        Validators.pattern('[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}')

      ]
    ],

    password: ['', [Validators.required, Validators.pattern('(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!#^~%*?&,.<>"\'\\;:\{\\\}\\\[\\\]\\\|\\\+\\\-\\\=\\\_\\\)\\\(\\\)\\\`\\\/\\\\\\]])[A-Za-z0-9\d$@].{7,}')]]
  });

  get f() {
    return this.signUpForm.controls;
  }


  handleFormSubmit() {


    if (this.password.invalid) {

      this.passwordFlag = true;
      return;
    }


    let login: Login = new Login();


    Object.assign(login, this.signUpForm.value);

    this.service.getLogin(login).subscribe(

      data => {

        console.log("backend date " + data);

        //console.log(this.attempts);

        if (data != null) {

          // localStorage.setItem('role',data);

          sessionStorage.setItem('role', data);
          sessionStorage.setItem('username', login.email);


          console.log("username :: " + login.email);

          // alert('Login successfully');
         // this.toaster.Warning("Login successfully");
          if (data == 'status_change') {
            this.toaster.Success("Login successfully");
            this.router.navigateByUrl('change-password');

          }
          if (data == 'Patient') {
            this.toaster.Success("Login successfully");
            this.router.navigateByUrl('app-body-layout/patient-details');
          }

          if (data == 'Admin') {
            this.toaster.Success("Login successfully");
            this.router.navigateByUrl('/admin-dashboard/hospital-users');
          }



          if (data == 'Physician') {
            this.toaster.Success("Login successfully");
            // this.router.navigateByUrl('/physician-dashboard/patient-details');
            this.router.navigateByUrl('/physician-dashboard/recieved-notes');
          }

          if (data == 'Nurse') {
            this.toaster.Success("Login successfully");
            this.router.navigateByUrl('/nurse-dashboard/recieved-notes');
          }

          console.log("Login successfully..")
        }
        if (data == "UsernamePass") {
          this.attempts = 6;
        }

        if (data == "BLOCKED") {

          this.attempts = 4;
          return;
        }

        this.attempts = data;


      },
      error => {
        console.log(error);
      }
    );
  }




  get email() {
    return this.signUpForm.get('email');
  }

  get password() {
    return this.signUpForm.get('password');
  }
}
