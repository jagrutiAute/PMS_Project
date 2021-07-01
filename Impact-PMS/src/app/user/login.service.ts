import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { User } from "./user";


@Injectable()
export class LoginService {
  baseUrl = 'http://localhost:8080';
//baseUrl= 'http://localhost:3000';
  constructor(private _http: HttpClient) {}

  getLogin(user:User): Observable<User> {
      console.log("heeeeee");
      //return this._http.get<User>(this.baseUrl + '/login'+JSON.stringify(user));
    return this._http.get<User>(this.baseUrl + '/login'+'?username='+ user.email +'&password='+user.password);
//http://localhost:8080/login?username=test1@gmail.com&password=tes1@123  
}

}
