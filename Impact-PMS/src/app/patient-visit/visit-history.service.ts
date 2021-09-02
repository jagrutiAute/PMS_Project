import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Medication1 } from '../admin/medication1';
import { VistihistoryDates } from './patient-visit-history/visithistroydates';

@Injectable({
  providedIn: 'root'
})
export class VisitHistoryServic{
  constructor(private router: Router,private _http: HttpClient) {}
  private baseUrl1 = 'http://localhost:8904';
  private baseUrl2 = 'http://localhost:8088';


  getVisitHistoryDates(pid:string):Observable<VistihistoryDates[]>{
      console.log(pid);
      let res=this._http.get<VistihistoryDates[]>(`${this.baseUrl1}`+'/reports-service/patient/visit/'+ `${pid}`);
    return res;
  
  }

  getMedicationforSpecificDate(date: string): Observable<Medication1[]>{
   let pid = sessionStorage.getItem('mrnNumber');
   
    return this._http.get<Medication1[]>(`${this.baseUrl2}/medication/`+`${pid}/`+`${date}`)
  }

  downloadMedication(date: string): Observable<Blob>{
    let pid = sessionStorage.getItem('mrnNumber');
   
      const httpOptions = {​​​
    responseType: 'blob' as 'json',
    headers: new HttpHeaders({​​​
      
    }​​​)
  }​​​;

     return this._http.get<Blob>(`${this.baseUrl2}/medication/download/`+`${pid}/`+`${date}`,{responseType: 'blob' as 'json'})
   }

}



