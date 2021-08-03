import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";


@Injectable()
export class AdminDashBoardService {


    
  private baseUrl = 'http://localhost:8081';  
  
  constructor(private _http: HttpClient) { }

  getPatient(): Observable<any> {
   
      
      //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123
      return this._http.get(this.baseUrl+'/patient'); 
      
  }

  getPatientById(id:number){

    return this._http.get(this.baseUrl+'/patient'+id); 
  }
}