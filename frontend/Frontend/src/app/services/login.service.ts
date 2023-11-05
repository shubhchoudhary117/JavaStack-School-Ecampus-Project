import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  // define the signup api url path
  private url:String="http://localhost:7070/revecampus/student"
  doLogin(logingData:any){
    return this.http.post(`${this.url}/login`,logingData);
  }

  // set token in localstorage
  setToken(token:any){
    localStorage.setItem("token",token)
  }
}
