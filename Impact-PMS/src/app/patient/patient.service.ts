import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { PatientDetails } from "./patientDetail";

@Injectable({ providedIn: 'root' })
export class PatientDetailService {

    private baseurl = "http://localhost:8080/updatePatientDetails";
    private baseurl1 = "http://localhost:8080/getPatientDetails/1";

    constructor(private _http: HttpClient) { }


    updatePatientDetails(patientDetails: PatientDetails): Observable<any> {
        console.log("insdervice");
        let result = this._http.post(`${this.baseurl}`, patientDetails, { responseType: 'text' as 'json' });
        
        console.log("result is " + result);
        return result;
    }

    getPatientDetails(): Observable<PatientDetails> {

        console.log("PatientDetails::::::" + this._http.get(`${this.baseurl1}`, { responseType: 'text' }))

        return this._http.get<PatientDetails>(`${this.baseurl1}`);
    }

}