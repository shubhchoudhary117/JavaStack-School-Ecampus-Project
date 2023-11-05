import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminProfileService {

  constructor(private http:HttpClient) { }

  // declare the url variable
  url:any="http://localhost:7070/admindetails"

  // fetch admin details for backend api
  getAdminDetails(){
    return this.http.get(`${this.url}/getdetails`)
  }

}
