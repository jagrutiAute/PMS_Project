import { Component, OnInit } from '@angular/core';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { AdminDashBoardService } from '../admin.service';
import { Procedure } from '../procedure';

@Component({
  selector: 'app-patient-procedure-details',
  templateUrl: './patient-procedure-details.component.html',
  styleUrls: ['./patient-procedure-details.component.css']
})
export class PatientProcedureDetailsComponent implements OnInit {

  procedures: Procedure[];

  constructor(private service: AdminDashBoardService,
    private toaster: ToasterService1) { }

  ngOnInit(): void {
    this.reload();
  }

  reload() {


    this.service.getAddeProcedures().subscribe((data) => {

      this.procedures = data;

      console.log(data)

    },
      (error) => {
        console.log(error)
      })
  }

  reloadCurrentPage() {
    window.location.reload();
  }
}
