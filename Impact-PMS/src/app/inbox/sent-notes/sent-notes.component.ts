import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Notes } from 'src/app/inbox/notes';
import { InboxService } from '../inbox.service';

@Component({
  selector: 'app-sent-notes',
  templateUrl: './sent-notes.component.html',
  styleUrls: ['./sent-notes.component.css']
})
export class SentNotesComponent implements OnInit {

  panelOpenState = false;
  sender = sessionStorage.getItem('username')
  notes: Notes[]

  constructor(private service: InboxService, private router: Router) { }

  ngOnInit(): void {
    console.log(sessionStorage.getItem('username'));
    this.service.getAllSentNotes(this.sender).subscribe(
      (data) => {
        console.log(data)
        this.notes=data
        // for(let d in this.notes){
        //   if( d.isUrgent )
        // }
      },
      (error) => {
        console.log(error)
      }
    )

  }

  // onClick(){
  //   this.router.navigateByUrl("/physician-dashboard/notes")
  // }

}
