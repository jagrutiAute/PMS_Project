import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AdminDashBoardService } from '../admin.service';
import { Patient } from '../patient';

@Component({
  selector: 'app-patient-users',
  templateUrl: './patient-users.component.html',
  styleUrls: ['./patient-users.component.css']
})
export class PatientUsersComponent implements OnInit {

  patients:Patient[];
  @ViewChild('userForm') userForm:ElementRef;
  constructor(private adminDashBoardService: AdminDashBoardService, private router:ActivatedRoute) { }

  ngOnInit(){
    //throw new Error('Method not implemented.');
    this.adminDashBoardService.getPatient().subscribe(data => {
        this.patients=data;
      },
      error => {
        console.log(error);
      })

     
  }
@ViewChild('id') id:ElementRef;


  editSubmit(index:number){
    console.log(this.patients[index]);
    this.id.nativeElement.value = this.patients[index].id;
    /* this.patients[index].id;
    firstName this.patients[index].firstName,
    lastName: this.patients[index].lastName,
    this.date_of_joining.nativeElement.value = this.patients[index].date_of_joining;
    this.status.nativeElement.value = this.patients[index].status;
    /*this.userForm.nativeElement({
      
      id: this.patients[index].id,
      firstName: this.patients[index].firstName,
      lastName: this.patients[index].lastName,
      date_of_joining:this.patients[index].date_of_joining,
      status: this.patients[index].status
    })*/
}

}
