import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from "./user";


@Injectable({ providedIn: 'root'})
export class LoginService {
  baseUrl = 'http://localhost:8080/login';
  //baseUrl= 'http://localhost:3000';
  constructor(private _http: HttpClient) { }

  getLogin(user: User): Observable<User> {
    console.log("heeeeee");
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa("gaurav@gmail.com" + ':' + "Gaurav@94") });
    //return this._http.get<User>(this.baseUrl + '/login'+JSON.stringify(user));
    //return this._http.get<User>(this.baseUrl  + '?username=' + user.email + '&password=' + user.password);

    return this._http.get<User>("http://localhost:8080/login",{headers,responseType: 'text' as 'json'});

    //http://localhost:8080/login?username=test1@gmail.com&password=tes1@123  
  }

}


