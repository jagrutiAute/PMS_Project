import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from "./user";


@Injectable({ providedIn: 'root'})
export class LoginService {
 // baseUrl = 'http://localhost:8080/login';
  //baseUrl= 'http://localhost:3000';
  private baseUrl1 = 'http://localhost:8080/login';  
  constructor(private _http: HttpClient) { }

  getLogin(user: User): Observable<any> {
   
    
    //return this._http.get<User>(this.baseUrl + '/login'+JSON.stringify(user));
    //return this._http.get<User>(this.baseUrl  + '?username=' + user.email + '&password=' + user.password);

    //return this._http.get<User>("http://localhost:8080/login",{headers,responseType: 'text' as 'json'});
      return this._http.post(`${this.baseUrl1}`, user,{responseType: 'text' as 'json'}); 
  
    //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123  
  }

}


