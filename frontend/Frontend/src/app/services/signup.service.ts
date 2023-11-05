import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http:HttpClient) { }

  // define the signup api url path
  private url:String="http://localhost:7070"
  // declare headers
  postSignup(data:any){
    return this.http.post(`${this.url}/signup`,data);
  }
}
