import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Patient } from "./patient";


@Injectable()
export class AdminDashBoardService {
 // private baseUrl = 'http://localhost:8081';


    
  private baseUrl = 'http://localhost:8085';  
  
  constructor(private _http: HttpClient) { }

  getPatient(): Observable<any> {
    //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
    return this._http.get(this.baseUrl + '/patient');
  }

  getPatientById(id:number): Observable<any>{

    return this._http.get(this.baseUrl+'/patient/'+id); 
  }

  addPatient(patient: Object): Observable<Object>{

    return this._http.post(`${this.baseUrl}/patient`, patient, { responseType: 'text' as 'json' }); 
  }

  updatePatintById(id:number, value: any): Observable<any>{

    return this._http.put(`${this.baseUrl}/patient/${id}`, value, { responseType: 'text' as 'json' }); 
  }

  deleteEmployee(id: number): Observable<any> {
    return this._http.delete(`${this.baseUrl}/patient/${id}`, { responseType: 'text' });
  }


}