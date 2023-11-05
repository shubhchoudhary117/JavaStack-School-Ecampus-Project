import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StudentprofileService {

  constructor(private http:HttpClient) { }

  // declare api url
  URL:any="http://localhost:7070/revecampus/student/profile";
  getStudentProfile(token:any){
    return this.http.get(`${this.URL}/getstudent/${token}`)
  }

  
}
