import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/QuizeService/category.service';

@Component({
  selector: 'app-showcategories',
  templateUrl: './showcategories.component.html',
  styleUrls: ['./showcategories.component.css']
})
export class ShowcategoriesComponent implements OnInit{
  constructor(private categoryService:CategoryService){}
  // decalre the variable
  categoriesData:any=[];
  ngOnInit() {
    this.categoryService.getCategories().subscribe(
      (response:any)=>{
        this.categoriesData=response;
      },
      (err:any)=>{
        console.log(err)
      }

    )
  }

}
