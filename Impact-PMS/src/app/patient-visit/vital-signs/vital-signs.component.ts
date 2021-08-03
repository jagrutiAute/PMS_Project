import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vital-signs',
  templateUrl: './vital-signs.component.html',
  styleUrls: ['./vital-signs.component.css']
})
export class VitalSignsComponent implements OnInit {

  constructor(
    private fb: FormBuilder,
    private router: Router,
    
  ) { }

  ngOnInit(): void {
  }

  vitalForm = this.fb.group({

    Height: ['', [Validators.required]],
    Weight: ['', [Validators.required]],
    Blood_Pressure: ['', [Validators.required]],
    Body_Temperature: ['', [Validators.required]]
    

  });


  handleFormSubmit() {

   
    

    // Object.assign(, this.vital_signs_form.value);

    
  }


  get f(){
    return this.vitalForm.controls;
  }



}
