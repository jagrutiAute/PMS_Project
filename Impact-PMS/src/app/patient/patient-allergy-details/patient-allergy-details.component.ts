import { Component, OnInit } from '@angular/core';
import { ToasterService1 } from 'src/app/toaster-service.service';
import { Allergy } from '../allergy';
import { PatientDetailService } from '../patient.service';

@Component({
  selector: 'app-patient-allergy-details',
  templateUrl: './patient-allergy-details.component.html',
  styleUrls: ['./patient-allergy-details.component.css']
})
export class PatientAllergyDetailsComponent implements OnInit {

  allergies: Allergy[];

  constructor(private service: PatientDetailService,
    private toaster: ToasterService1) { }

  ngOnInit(): void {

    this.reload();
  }

  reload() {


    this.service.getAddeAllergies().subscribe((data) => {

      this.allergies = data;

      console.log("inside app-patient-allergy-details: reload")
      console.log(data)

    },
      (error) => {
        console.log(error)
      })
  }

  deleteAllergy(id: number) {

    confirm("do you want to delete ?")
    this.service.deleteAllergies(id).subscribe((data) => {

      this.toaster.Success("deleted")

    },
      (error) => {
        console.log(error)
      })


  }



  reloadCurrentPage() {
    window.location.reload();
  }

}
