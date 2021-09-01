import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

import { Observable } from "rxjs";
import { Medication } from "./medication-master";
import { Medication1 } from "./medication1";


@Injectable()
export class MedicationService {

  private baseUrl = 'http://localhost:8088';  
  
  constructor(private _http: HttpClient) { }


  gerMedication(): Observable<Medication[]> {
    console.log("inside adminDashBoardservice")
    return this._http.get<Medication[]>(this.baseUrl + '/physician/medication');
  
  }


  addMedicationForPatient(medicationObject: Medication[]): Observable<any> {
   // let id: Number = 1;
    //let phyid: Number = 12;
    let pid = sessionStorage.getItem('pidforvisit');
    return this._http.post<any>(`${this.baseUrl}/physician/addmedication/${pid}`,medicationObject);

  }


  getAddedMedication(): Observable<Medication1[]> {
   
    let pid:string;
   
    if(sessionStorage.getItem('role')=='Physician'){
     pid = sessionStorage.getItem('pidforvisit');
    }else{
      pid =sessionStorage.getItem('mrnNumber');
    }

    console.log("Hjdkdldl"+this._http.get<Medication1[]>(this.baseUrl + '/physician/getAddedMedication'+pid));
    return this._http.get<Medication1[]>(this.baseUrl + '/physician/getAddedMedication/'+pid);
  }




}