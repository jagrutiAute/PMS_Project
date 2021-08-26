import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-physican-sidenav',
  templateUrl: './physican-sidenav.component.html',
  styleUrls: ['./physican-sidenav.component.scss']
})
export class PhysicanSidenavComponent implements OnInit {
  step = 0;

  setStep(index: number) {
    this.step = index;
  }

  constructor() { }

  ngOnInit(): void {
  }

  // panelOpenState = false;
}
