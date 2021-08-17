import { ToasterService1 } from 'src/app/toaster-service.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientService } from '../patient-registration.service';
import { User1 } from '../user1';
import { ConfirmedValidator } from './confirmed-equal.validator';

@Component({
  selector: 'app-registration-patient',
  templateUrl: './registration-patient.component.html',
  styleUrls: ['./registration-patient.component.css']
})
export class RegistrationPatientComponent implements OnInit {

  maxDate: any;
  isSubmitted = false;
  statusofEmail:boolean = true;
  emailAlredyExist = "";

  ngOnInit() {
    this.futureDateDisable();
  }

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private service: PatientService,
    private toaster: ToasterService1
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
   
     let patient1: Patient = new Patient();

    Object.assign(patient1, this.registerForm.value);

    this.service.getPatientRegister(patient1).subscribe(
      data => {
       console.log("data "+data);
      
        if(data=='user already exist')
        {
   
          this.emailAlredyExist = "User Alredy Exist";
          this.toaster.Warning("Email already exist");
        }
        else{
          //alert("Your succesfully registered")
          this.toaster.Success("Registered Successfully");
   
          this.router.navigate(['']);
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
