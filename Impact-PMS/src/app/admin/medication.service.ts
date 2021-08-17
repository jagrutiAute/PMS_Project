import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Medication } from "./admin-dashboard/medication-master";





@Injectable()
export class MedicationService {
 // private baseUrl = 'http://localhost:8081';

  private baseUrl = 'http://localhost:8088';  
  
  constructor(private _http: HttpClient) { }



  gerMedication(): Observable<Medication[]> {
    //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
    return this._http.get<Medication[]>(this.baseUrl + '/physician/medication');

  }



}