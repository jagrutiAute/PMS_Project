import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-body-layout',
  templateUrl: './body-layout.component.html',
  styleUrls: ['./body-layout.component.css']
})
export class BodyLayoutComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  title = 'admin-panel-layout';
  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }

}
