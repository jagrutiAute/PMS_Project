import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/auth.service';
import { Login } from 'src/app/Login';
import { ConfirmedValidator } from './confirmed-equal.validator';
import { Router } from '@angular/router';
import { JsonpClientBackend } from '@angular/common/http';
@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent {

  attempts: number;
  constructor(private fb: FormBuilder, private service: AuthService, private router: Router) { }

  changePasswordForm = this.fb.group({
    password: ['', Validators.required],
    new_password: ['', [Validators.required, Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$")]],
    confirm_password: ['', Validators.required]
  },
    {
      validator: ConfirmedValidator('new_password', 'confirm_password')
    });

  get password() { return this.changePasswordForm.get('password') }
  get new_password() { return this.changePasswordForm.get('new_password') }
  get confirm_password() { return this.changePasswordForm.get('confirm_password') }

  handleFormSubmit() {
    //console.log(this.changePasswordForm.value) 
    console.log(this.new_password.value)

    let logindetails = new Login();
    logindetails.email = sessionStorage.getItem('username');
    logindetails.password = this.password.value;
    //console.log ('change password'+this.service.getLogin(logindetails));
    this.service.getLogin(logindetails).subscribe(data => {
      this.attempts = data;
      console.log("password changed status");
      if (data == "BLOCKED") {

        alert("Your account blocked");
        this.router.navigateByUrl('login');
      }

      if (data == 'status_change') {
        let user = sessionStorage.getItem('username');
        let pass = this.new_password.value;
        // this.service.updatechangedstatus(user,pass).subscribe(
        //   (data1)=>{
        //               console.log(data1);
        //                 if(data1=="Update"){
        //                 alert('Your password changed successfully');
        //                 this.router.navigateByUrl('login');
        //                 }
        //          },
        //       (error)=>{
        //           console.log('in the error')
        //       }
        // );

        this.service.updatechangedstatus(user, pass).subscribe(

          data => {

            console.log("backend date " + JSON.parse(data));
            console.log("data stringfy" + JSON.stringify(data));

            //console.log(this.attempts);

            if (data = "Update") {
              alert('Login successfully');

              if (data == 'status_change') {
                let user = sessionStorage.getItem('username');
                let pass = this.new_password.value;
                // this.service.updatechangedstatus(user,pass).subscribe(
                //   (data1)=>{
                //               console.log(data1);
                //                 if(data1=="Update"){
                //                 alert('Your password changed successfully');
                //                 this.router.navigateByUrl('login');
                //                 }
                //          },
                //       (error)=>{
                //           console.log('in the error')
                //       }


                //          );


                this.service.updatechangedstatus(user, pass).subscribe(

                  data => {



                    console.log("backend date " + JSON.parse(data));
                    console.log("data stringfy" + JSON.stringify(data));


                    //console.log(this.attempts);



                    if (data = "Update") {

                      alert('Login successfully');



                    }


                  },
                  error => {
                    console.log('error');
                    alert('error while loging');
                    console.log("backend date " + JSON.parse(data));
                    console.log("data stringfy" + JSON.stringify(data));
                  }
                );


              }


            }
            //     ,
            //     error => {
            //       console.log(error);

            //       console.log("backend date " + JSON.parse(data));
            //       console.log("data stringfy" + JSON.stringify(data));
            //     }
            // );


          },
          error => {
            console.log(error)
          }
        )
      }
    }, error => {
      console.log(error)
    }
    )
  }
}
