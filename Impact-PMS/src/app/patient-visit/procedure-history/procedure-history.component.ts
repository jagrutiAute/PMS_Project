import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminDashBoardService } from 'src/app/admin/admin.service';
import { Procedure } from 'src/app/admin/procedure';

@Component({
  selector: 'app-procedure-history',
  templateUrl: './procedure-history.component.html',
  styleUrls: ['./procedure-history.component.css']
})
export class ProcedureHistoryComponent implements OnInit {

  procedure: Procedure[];
  date: any;
  constructor(private adminDashboardService: AdminDashBoardService, private route: ActivatedRoute){}
  

  ngOnInit(): void {
    this.route.params.subscribe(a => {
      this.date = a['id'];
          
        });
    this.reload();
  }

  reload(){

    this.adminDashboardService.getProcedureforspecificdate(this.date).subscribe((data)=>{
      this.procedure=data;
      console.log("inside patient-details: reload")
      console.log(data)
    },
    (error)=>{
      console.log(error)
    })
   }

   downloadDiagnosis(){
     
   }
}
