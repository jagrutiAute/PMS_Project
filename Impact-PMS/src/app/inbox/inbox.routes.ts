import { Route, RouterModule } from '@angular/router'
import { SentNotesComponent } from './sent-notes/sent-notes.component'

export var inboxroutes: Route[] = [
    { path: 'notesdetail', component: SentNotesComponent }
]

