import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-upcoming-appointment',
  templateUrl: './upcoming-appointment.component.html',
  styleUrls: ['./upcoming-appointment.component.css']
})
export class UpcomingAppointmentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  key: string = 'id';
  reverse:boolean = false;
  sort(key: string){
     this.key = key;
     this.reverse = !this.reverse;
  }
}
