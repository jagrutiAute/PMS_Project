import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Patient } from "./patient";


@Injectable({ providedIn: 'root'})


export class PatientService {
 
  private baseUrl = 'http://localhost:8080/register'; 
  
  constructor(private _http: HttpClient) { }

  getPatientRegister(patient: Patient): Observable<any> {
   
      return this._http.post(`${this.baseUrl}`, patient,{responseType: 'text' as 'json'}); 
      
  }
}