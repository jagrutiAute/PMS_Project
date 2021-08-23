import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Notes } from './notes';

@Injectable({
  providedIn: 'root'
})
export class InboxService {

  baseUrl = "http://localhost:8088"
  constructor(private _http: HttpClient) { }

  addNotes(note: Notes, email: String): Observable<any> {
    console.log("inside notes service");
    let result = this._http.post(`${this.baseUrl}` + '/notes/' + `${email}`, note, { responseType: 'text' });
    // return this._http.post(`${this.notesUrl}`, note, { responseType: 'text' });
    console.log("result " + result);
    return result;
  }

  getAllSentNotes(sender: any): Observable<Notes[]> {
    return this._http.get<Notes[]>(this.baseUrl + '/sent/' + sender);
  }

  getAllReceiveNotes(receiver: any): Observable<Notes[]> {
    return this._http.get<Notes[]>(this.baseUrl + '/received/' + receiver);
  }

  deleteNote(id: any): Observable<Notes> {
    return this._http.delete<Notes>(this.baseUrl + '/delete/' + id);
  }

}
