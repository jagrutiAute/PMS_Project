import { Component, OnInit } from '@angular/core';
import { Notes } from 'src/app/user/notes';
import { InboxService } from '../inbox.service';

@Component({
  selector: 'app-sent-notes',
  templateUrl: './sent-notes.component.html',
  styleUrls: ['./sent-notes.component.css']
})
export class SentNotesComponent implements OnInit {

  sender = sessionStorage.getItem('username')
  notes: Notes[]

  constructor(private service: InboxService) { }

  ngOnInit(): void {
    console.log(sessionStorage.getItem('username'));
    this.service.getAllSentNotes(this.sender).subscribe(
      (data) => {
        console.log(data)
        this.notes=data
      },
      (error) => {
        console.log(error)
      }
    )

  }

}
