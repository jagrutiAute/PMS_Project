import { Component } from '@angular/core';
import { FormBuilder, Validators ,FormGroup} from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../User';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  constructor(
    private fb: FormBuilder,
    private router: Router
  ) { }

  signUpForm = this.fb.group({

    email: [
      '',
      [
        Validators.required,
        Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,3}$')
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
    
  }

  get email() {
    return this.signUpForm.get('email');
  }
  
  get password() {
    return this.signUpForm.get('password');
  }
}
