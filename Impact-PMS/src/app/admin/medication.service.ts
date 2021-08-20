import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Medication } from "./medication-master";
import { Medication1 } from "./medication1";






@Injectable()
export class MedicationService {
 // private baseUrl = 'http://localhost:8081';

  private baseUrl = 'http://localhost:8088';  
  
  constructor(private _http: HttpClient) { }


  gerMedication(): Observable<Medication[]> {
    console.log("inside adminDashBoardservice")
    return this._http.get<Medication[]>(this.baseUrl + '/physician/medication');
  
  }


  addMedicationForPatient(medicationObject: Medication[]): Observable<any> {
    let id: Number = 1;
    let phyid: Number = 12;

    return this._http.post<any>(`${this.baseUrl}/physician/addmedication/${id}/${phyid}`,medicationObject);

  }

  getAddedMedication(): Observable<Medication1[]> {
    return this._http.get<Medication1[]>(this.baseUrl + '/physician/getAddedMedication');
  }

  // gerMedication(): Observable<Medication[]> {
  //   //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
  //   return this._http.get<Medication[]>(this.baseUrl + '/physician/medication');

  // }

  // addMedicationForPatient(medicationObject: Medication): Observable<Medication[]> {
  //   //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
  //   return this._http.post<Medication[]>(this.baseUrl + '/physician/addmedication',medicationObject);

  // }



}