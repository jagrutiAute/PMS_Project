import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientService } from '../patient-registration.service';
import { ConfirmedValidator } from './confirmed-equal.validator';

@Component({
  selector: 'app-registration-patient',
  templateUrl: './registration-patient.component.html',
  styleUrls: ['./registration-patient.component.css']
})
export class RegistrationPatientComponent implements OnInit {

  maxDate: any;
  isSubmitted = false;

  ngOnInit() {
    this.futureDateDisable();
  }

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service: PatientService
  ) { }


  registerForm = this.fb.group({

    email: ['', [Validators.required, Validators.pattern('[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}')]],

    password: ['', [Validators.required, Validators.pattern('(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!#^~%*?&,.<>"\'\\;:\{\\\}\\\[\\\]\\\|\\\+\\\-\\\=\\\_\\\)\\\(\\\)\\\`\\\/\\\\\\]])[A-Za-z0-9\d$@].{7,}')]],

    title: ['', [Validators.required]],
    fname: ['', [Validators.required, Validators.minLength(2)]],
    lname: ['', [Validators.required, Validators.minLength(2)]],
    dob: ['', [Validators.required]],
    contact: ['', [Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
    pwd: ['', [Validators.required, Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$")]],
    cpwd: ['', Validators.required]

  },
    {
      validator: ConfirmedValidator('pwd', 'cpwd')
    }
  );


  handleFormSubmit() {

    let patient: Patient = new Patient();

    Object.assign(patient, this.registerForm.value);
    //console.log(user);
    this.service.getPatientRegister(patient).subscribe(
      data => {
        if (data == 'success') {
          console.log("data is" + data);
          alert('You are successfully register');
          //this.router.navigateByUrl('/customer/login');
        } else {

          console.log(' data ' + data);

        }


      },
      error => {
        console.log(error);
      }
    );
  }



  futureDateDisable() {
    var date: any = new Date();
    var todayDate: any = date.getDate();
    var month: any = date.getMonth();
    var year: any = date.getFullYear();
    if (todayDate < 10) {
      todayDate = '0' + todayDate;
    }
    if (month < 10) {
      month = '0' + month;
    }
    this.maxDate = year + "-" + month + "-" + todayDate;

  }

  get title() {
    return this.registerForm.get('title');

  }

  get fname() {
    return this.registerForm.get('fname');

  }
  get lname() {
    return this.registerForm.get('lname');

  }

  get email() {
    return this.registerForm.get('email');
  }

  get dob() {
    return this.registerForm.get('dob');

  }
  get contact() {
    return this.registerForm.get('contact');

  }
  get pwd() {
    return this.registerForm.get('pwd');

  }
  get cpwd() {
    return this.registerForm.get('cpwd');

  }




}
