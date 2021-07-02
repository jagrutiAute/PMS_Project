import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
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

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service: LoginService
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

    //if (this.signUpForm.valid) { console.log('form submitted'); } else { console.log("Not valid") }

    // console.log(this.signUpForm.value);
    let user: User = new User();
    Object.assign(user, this.signUpForm.value);
    //console.log(user);
    this.service.getLogin(user).subscribe(
      data => {
        if (data != null) {
          console.log("data is" + data);
          alert('You are successfully registered.');
          //this.router.navigateByUrl('/customer/login');
        }
      },
      error => {
        console.log(error);
      }
    );

<<<<<<< HEAD
=======
  // console.log(this.signUpForm.value);
  let user: User = new User();
  user.id=1;
  Object.assign(user, this.signUpForm.value);
  //console.log(user);
  this.service.getLogin(user).subscribe(
  data => {
  if (data != null) {
    console.log("data is"+data);
  alert('You are successfully registered.');
  //this.router.navigateByUrl('/customer/login');
  }
  },
  error => {
  console.log(error);
  }
  );
>>>>>>> 4c5b81ac859cd867216217bd0a8ae5f55287afbc

  }




  get email() {
    return this.signUpForm.get('email');
  }

  get password() {
    return this.signUpForm.get('password');
  }
}
