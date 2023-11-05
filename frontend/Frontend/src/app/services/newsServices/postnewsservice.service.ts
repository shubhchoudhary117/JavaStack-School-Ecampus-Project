import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PostnewsserviceService {

  constructor(private http:HttpClient) { }
  URL:any="http://localhost:7070/admin/news";
  // define the add post api function
  addNewsApi(news:any){
    return this.http.post(`${this.URL}/addnews`,news);
  }

  // get all news
  getNewsApi(){
    return this.http.get(`${this.URL}/getnews`)
  }
}
