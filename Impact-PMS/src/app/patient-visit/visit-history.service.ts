import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { VistihistoryDates } from './patient-visit-history/visithistroydates';

@Injectable({
  providedIn: 'root'
})
export class VisitHistoryServic{
  constructor(private router: Router,private _http: HttpClient) {}
  private baseUrl1 = 'http://localhost:8904';


  getVisitHistoryDates(pid:string):Observable<VistihistoryDates[]>{
      console.log(pid);
      let res=this._http.get<VistihistoryDates[]>(`${this.baseUrl1}`+'/reports-service/patient/visit/'+ `${pid}`);
    return res;
  
  }


}
