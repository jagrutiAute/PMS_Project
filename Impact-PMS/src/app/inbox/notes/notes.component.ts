import { User } from '../../admin/user';
import { FormBuilder, Validators } from '@angular/forms';
import { ToasterService1 } from '../../toaster-service.service';
import { Notes } from '../notes';
import { LoginService } from '../../user/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  status: String;
  user: User;
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

    message: ['', Validators.required],
    isUrgent: ['', Validators.required]
  });

  get f() {
    return this.notesForm.controls;
  }

  sendNote() {
    console.log("inside sendNotes method");
    let note: Notes = new Notes();
    let email = sessionStorage.getItem('username');
    Object.assign(note, this.notesForm.value);
    this.service.addNotes(note, email).subscribe(
      data => {
        console.log("data " + data);
        this.status = data;
        console.log("status  " + this.status);

        this.toaster.Success(" Notes Send Successfully");
        window.location.reload();
        // alert('Your password reset successfully');
        // this.router.navigate(['/login']);

      },
      error => {
        console.log(error);
      }
    );
  }

}
