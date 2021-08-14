import { Component } from '@angular/core';



@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent {

 /* @ViewChild(RouterOutlet) outlet: RouterOutlet;



  public source: Array<{ text: string; value: number }> = [
    { text: "Small", value: 1 },
    { text: "Medium", value: 2 },
    { text: "Large", value: 3 }
  ];

  public data: Array<{ text: string; value: number }>;

  constructor(private router: Router) {
    this.data = this.source.slice();
  }


  handleFilter(value) {
    this.data = this.source.filter(
      (s) => s.text.toLowerCase().indexOf(value.toLowerCase()) !== -1
    );
  }


  ngOnInit() {
    this.router.events.subscribe(e => {
      if (e instanceof ActivationStart && e.snapshot.outlet === "administration")
        this.outlet.deactivate();
    },
    error => console.log(error));
  } */
}
