import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TeacherServicesService {

  constructor(private http:HttpClient) { }

  url:String="http://localhost:7070/teachers"
  getTeacherDetails()
  {
    return this.http.get(`${this.url}/teacherdetails`)
  }

  // get teacher details by teacher name
  getTeacherByTeacherName(name:any){
    return this.http.get(`${this.url}/teacherbyname/${name}`)
  }

  
  // get teacher details by teacher name
  getTeacherByTeacherId(tid:any){
    return this.http.get(`${this.url}/teacherbyid/${tid}`)
  }
}
