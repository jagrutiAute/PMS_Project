import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Diagnosis } from "./diagnosis";


@Injectable()
export class DiagnosisService {

 private baseUrlDiagnosis = "http://localhost:8082";  
  
  constructor(private _http: HttpClient) { }


  getDiagnosis(): Observable<Diagnosis[]> {
    return this._http.get<Diagnosis[]>(this.baseUrlDiagnosis + '/physician/diagnosis');
  }


  addDiagnosisForPatient(diadnosisObject: Diagnosis[]): Observable<any> {
    let id: Number = 1;
    let phyid: Number = 12;
    return this._http.post<any>(`${this.baseUrlDiagnosis}/physician/addDiagnosis/${id}/${phyid}`,diadnosisObject);
  }

  
  getAddedDiagnosis(): Observable<Diagnosis[]> {
    return this._http.get<Diagnosis[]>(this.baseUrlDiagnosis + '/physician/getAddedDiagnosis');
  }

}