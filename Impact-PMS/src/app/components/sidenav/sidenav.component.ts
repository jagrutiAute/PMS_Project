import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.scss'],
  encapsulation: ViewEncapsulation.None

})
export class SidenavComponent implements OnInit {
  step = 0;

  setStep(index: number) {
    this.step = index;
  }

  constructor() { }

  ngOnInit(): void {
  }

  // panelOpenState = false;

}




