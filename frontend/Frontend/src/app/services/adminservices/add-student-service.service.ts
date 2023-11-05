import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AddStudentServiceService {

  constructor(private http:HttpClient) { }

  // declare the api function for calling the add student api
  URL:any="http://localhost:7070/admin/student";
  addNewStudent(student:any){
    return this.http.post(`${this.URL}/addstudent`,student)
  }
}
