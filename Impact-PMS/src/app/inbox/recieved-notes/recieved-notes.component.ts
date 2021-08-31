import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Notes } from 'src/app/inbox/notes';
import { InboxService } from '../inbox.service';

@Component({
  selector: 'app-recieved-notes',
  templateUrl: './recieved-notes.component.html',
  styleUrls: ['./recieved-notes.component.css']
})
export class RecievedNotesComponent implements OnInit {
  panelOpenState = false;
  receiver = sessionStorage.getItem('username')
  notes: Notes[]

  constructor(private service: InboxService, private router: Router) { }

  ngOnInit(): void {
    // console.log(sessionStorage.getItem('username'));
    this.loadNotes()
  }

  loadNotes() {
    this.service.getAllReceiveNotes(this.receiver).subscribe(
      (data) => {
        // console.log(data)
        this.notes = data
        for (var n in this.notes) {
          if (this.notes[n].isRead) {
          } else {
            
          }

        }
      },
      (error) => {
        console.log(error)
      }
    )
  }

  onClick() {
    this.router.navigateByUrl("/physician-dashboard/notes")
  }

  onDelete(id: any) {
    if (window.confirm('Are you sure, you want to delete?')) {
      this.service.deleteNote(id).subscribe(
        data => {
          // this.loadNotes()
          console.log("Note deleted successfully...")
          window.location.reload();
        },
        error => {
          console.log(error)
        }
      )
    }
  }

}
