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
    let id: string=sessionStorage.getItem('pidforvisit');
    let phyid= sessionStorage.getItem('username');
    
    return this._http.post<any>(`${this.baseUrlDiagnosis}/physician/addDiagnosis/${id}/${phyid}`,diadnosisObject);
  }

  
  getAddedDiagnosis(): Observable<Diagnosis[]> {
    let pid:string;
   
    if(sessionStorage.getItem('role')=='Physician'){
     pid = sessionStorage.getItem('pidforvisit');
    }else{
      pid =sessionStorage.getItem('mrnNumber');
    }
    
       
    return this._http.get<Diagnosis[]>(this.baseUrlDiagnosis + '/physician/getAddedDiagnosis/'+pid);
  }

}