import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommanStudentServiceService {

  constructor(private http:HttpClient) { }

  URL:any="http://localhost:7070/admin/institute/get-availabel-class";
  getStudentClassCategory(){
    return this.http.get(this.URL);
  }




}
