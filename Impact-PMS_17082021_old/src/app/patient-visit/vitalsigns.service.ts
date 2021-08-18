import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Vital } from "./vital";

@Injectable({ providedIn: 'root'})
export class VitalSignsService {

    private baseUrl1 = 'http://localhost:8081/vitalsigns';  

    constructor(private _http: HttpClient) { }

    addVitalSigns(vital:Vital ): Observable<any> {

        return this._http.post(`${this.baseUrl1}`, vital,{responseType: 'text' as 'json'});
        
    }
}