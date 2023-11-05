import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient) { }


  // http://localhost:7070
  url:any="http://localhost:7070/category"
  // add category 
  addCategory(categoryData:any){
    return this.http.post(`${this.url}/addcategory`,categoryData)
  }

  // get all categories
  getCategories(){
    return this.http.get(`${this.url}/getcategories`)
  }
}
