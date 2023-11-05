import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StudentreletedService implements OnInit{

  constructor(private http:HttpClient) { }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


  // define the update student profiel api 
  url:any="http://localhost:7070/revecampus/student/profile";
  
  doUpdateProfileApi(updatingDetails:any){
    return this.http.post(`${this.url}/update`,updatingDetails);
  }



}
