import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nurse-sidenav',
  templateUrl: './nurse-sidenav.component.html',
  styleUrls: ['./nurse-sidenav.component.scss']
})
export class NurseSidenavComponent implements OnInit {
  step = 0;

  setStep(index: number) {
    this.step = index;
  }

  constructor() { }

  ngOnInit(): void {
  }

  // panelOpenState = false;
}
