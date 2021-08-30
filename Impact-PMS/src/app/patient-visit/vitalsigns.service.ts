import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Vital } from "./vital";

@Injectable({ providedIn: 'root'})
export class VitalSignsService {

    private baseUrl1 = 'http://localhost:8092/vitalsigns';
    private getVitalsignUrl = 'http://localhost:8092/getvitalsigns';  

    constructor(private _http: HttpClient) { }

    fetchVitalSigns(pid:string ): Observable<any> {       

        return this._http.get(`${this.getVitalsignUrl}/${pid}`);
        
    } 

    addVitalSigns(vital:Vital ): Observable<any> {

        return this._http.post(`${this.baseUrl1}`, vital,{responseType: 'text' as 'json'});
        
    }
}