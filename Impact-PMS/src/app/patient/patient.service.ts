import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Ethinicity } from "./ethinicity";
import { PatientDetails } from "./patientDetail";
import { Race } from "./race";

@Injectable({ providedIn: 'root' })
export class PatientDetailService {

    private baseurl = "http://localhost:8094/updatePatientDetails";
    private baseurl1 = "http://localhost:8094/getPatientDetails/1";
    private raceUrl = "http://localhost:8094/getRaceList"
    private ethinicityUrl = "http://localhost:8094/getEthinicityList"

    constructor(private _http: HttpClient) { }


    updatePatientDetails(patientDetails: PatientDetails): Observable<any> {
        
        let result = this._http.post(`${this.baseurl}`, patientDetails, { responseType: 'text' as 'json' });

        console.log("result is " + result);
        return result;
    }

    getPatientDetails(): Observable<PatientDetails> {

        console.log("PatientDetails::::::" + this._http.get(`${this.baseurl1}`, { responseType: 'text' }))

        return this._http.get<PatientDetails>(`${this.baseurl1}`);
    }

    getAllRace(): Observable<Race[]> {

        console.log("Race::::::" + this._http.get(`${this.raceUrl}`, { responseType: 'text' }))

        return this._http.get<Race[]>(`${this.raceUrl}`);
    }

    getEthinicity(): Observable<Ethinicity[]> {

        console.log("Ethinicity::::::" + this._http.get(`${this.ethinicityUrl}`, { responseType: 'text' }))

        return this._http.get<Ethinicity[]>(`${this.ethinicityUrl}`);
    }

}