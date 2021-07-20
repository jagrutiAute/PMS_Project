import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { LoginService } from '../login.service';
import { User } from '../user';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent  {

  user: User;
  status:String;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service: LoginService
    
  ) { }

  forgotPassForm = this.fb.group({

    email: [
      '',
      [
        Validators.required,
        Validators.pattern('[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}')

      ]
    ]

  });

  get f() {
    return this.forgotPassForm.controls;
  }

  forgotPass(){

    //call service after that redirect to login page
    console.log("this.forgotPassForm.value ::  "+this.forgotPassForm.get("email").value);

    this.service.getForgotPassword(this.forgotPassForm.get("email").value).subscribe(
      data => {
       
          console.log("data is" + data);
          this.status=data;
          console.log(this.status);
             
      },
      error => {
        console.log(error);
      }
    );
  }



}
