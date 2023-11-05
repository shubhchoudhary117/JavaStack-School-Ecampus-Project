import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuizeService implements OnInit{

  constructor(private http:HttpClient) { }
  ngOnInit() {
  }

  // set url variable
  quizeUrl:any="http://localhost:7070/quize"
  categoryUrl:any="http://localhost:7070/category"
  // create add quize api
  addQuize(quizeData:any){
    return this.http.post(`${this.quizeUrl}/addquize`,quizeData)
  }

  // get quizes
  getQuizes(){
    return this.http.get(`${this.quizeUrl}/getquizes`)
  }

  // get all categories
  getCategories(){
    return this.http.get(`${this.categoryUrl}/getcategories`)
  }

  // delete quize
  deleteQuize(id:any){
    return this.http.delete(`${this.quizeUrl}/delete-quize/${id}`)
  }

}
