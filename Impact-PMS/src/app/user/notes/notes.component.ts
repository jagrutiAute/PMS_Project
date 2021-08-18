import { FormBuilder, Validators } from '@angular/forms';
import { ToasterService1 } from './../../toaster-service.service';
import { Notes } from './../notes';
import { LoginService } from './../login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  status: String;
  constructor(
    private service: LoginService,
    private toaster: ToasterService1,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
  }
  notesForm = this.fb.group({

    reciever: [
      '',
      Validators.required
    ],

    subject: ['', Validators.required],
    message: ['', Validators.required],
    isUrgent: ['', Validators.required]
  });

  get f() {
    return this.notesForm.controls;
  }

  sendNote() {
    console.log("inside sendNotes method");
    let note:Notes=new Notes();
    Object.assign(note, this.notesForm.value);
    console.log("Hello")
    this.service.addNotes(note).subscribe(
      data => {
        console.log("data " + data);
        this.status = data;
        console.log("status  " + this.status);
        if (this.status == "Success") {
          this.toaster.Success(" Notes Send Successfully");
          // alert('Your password reset successfully');
          // this.router.navigate(['/login']);
        }
      },
      error => {
        console.log(error);
      }
    );
  }

}
