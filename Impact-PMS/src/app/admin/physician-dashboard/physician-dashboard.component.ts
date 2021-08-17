import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-physician-dashboard',
  templateUrl: './physician-dashboard.component.html',
  styleUrls: ['./physician-dashboard.component.css']
})
export class PhysicianDashboardComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  title = 'admin-panel-layout';
  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

}
