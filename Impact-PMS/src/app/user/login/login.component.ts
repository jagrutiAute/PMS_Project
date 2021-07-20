import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from 'src/app/Login';
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
    let login: Login = new Login();
    Object.assign(login, this.signUpForm.value);
    //console.log(user);
    this.service.getLogin(login).subscribe(
      data => {
        if (data == 0) {
          console.log("data is" + data);


          alert('You are successfully login');
          //this.router.navigateByUrl('/customer/login');
        }else{

            console.log('data'+data);
            
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
