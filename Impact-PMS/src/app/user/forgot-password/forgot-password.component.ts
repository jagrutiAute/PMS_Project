import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent  {

  user: User;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    
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
  }

}
