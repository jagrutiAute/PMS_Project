import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ConfirmedValidator } from './confirmed-equal.validator';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent {
  constructor(private fb: FormBuilder) { }

  changePasswordForm = this.fb.group({
    password: ['', Validators.required],
    new_password: ['', 
                      [
                        Validators.required, 
                        Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$")
                      ]
    ],
    confirm_password: ['', Validators.required]
  },
  { 
    validator: ConfirmedValidator('new_password', 'confirm_password')
  });

  get password() { return this.changePasswordForm.get('password') }
  get new_password() { return this.changePasswordForm.get('new_password') }
  get confirm_password() { return this.changePasswordForm.get('confirm_password') }

  handleFormSubmit() {
    console.log(this.changePasswordForm.value)  
  }
}
