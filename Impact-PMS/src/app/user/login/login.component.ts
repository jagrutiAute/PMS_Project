import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators ,FormGroup} from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
user:User;

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
        Validators.pattern('/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/')
      ]
    ],

    password: ['', [Validators.required, Validators.pattern('(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!#^~%*?&,.<>"\'\\;:\{\\\}\\\[\\\]\\\|\\\+\\\-\\\=\\\_\\\)\\\(\\\)\\\`\\\/\\\\\\]])[A-Za-z0-9\d$@].{7,}')]]
  });

  get f()
{
    return this.signUpForm.controls;
}
handleFormSubmit() {
  // console.log(this.signUpForm.value);
  let user: User = new User();
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
  }
    

  get email() {
    return this.signUpForm.get('email');
  }
  
  get password() {
    return this.signUpForm.get('password');
  }
}
