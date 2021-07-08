import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-registration-provider',
  templateUrl: './registration-provider.component.html',
  styleUrls: ['./registration-provider.component.css']
})
export class RegistrationProviderComponent implements OnInit{

  maxDate: any;

  ngOnInit(){
    this.futureDateDisable();
  }
  futureDateDisable(){
    var date: any = new Date();
    var todayDate: any = date.getDate();
    var month: any = date.getMonth();
    var year: any = date.getFullYear();
    if(todayDate<10){
       todayDate='0'+ todayDate;
    }
    if(month<10){
      month='0'+ month;
   }
   this.maxDate=year + "-" + month + "-" + todayDate;
    
  }
  
  user: User;

  constructor(
    private fb: FormBuilder,
    private router: Router
  
  ) 
  
  { }

  signUpFormProvider = this.fb.group({
    title: ['', Validators.required],
    firstName: ['', 
              [Validators.required,
              Validators.minLength(2)
              ]
            ],
    lastName: ['', 
              [Validators.required,
              Validators.minLength(2)
              ]],

    email: [
      '',
      [
        Validators.required,
        Validators.pattern('[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}')

      ]
    ],
    dob:['', Validators.required],
    role: ['', Validators.required],
    employeeid:['', Validators.required]
   


  });

  get f() {
    return this.signUpFormProvider.controls;
  }




}
