import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwtauthenticationService {

  constructor(private http:HttpClient) { }

  // post request in backend with jwt token for checking user is authenticated or not
  private url:String="http://localhost:7070/revecampus/student"
  doAuthentication(details:any){
    return this.http.post(`${this.url}/authenticate`,details)
  }
}
