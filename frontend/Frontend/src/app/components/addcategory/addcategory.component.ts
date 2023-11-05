import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/QuizeService/category.service';

@Component({
  selector: 'app-addcategory',
  templateUrl: './addcategory.component.html',
  styleUrls: ['./addcategory.component.css']
})
export class AddcategoryComponent implements OnInit{

  constructor(private categoryService:CategoryService,private router:Router){}
  ngOnInit(): void {
  
  }

  // define the data for storing category title and description
  categoryData={
    title:"",
    description:""
  }
  // declare the field validation variable
  allFieldsEmpty:Boolean=false;
  titleFieldEmpty:Boolean=false;
  descriptionFieldEmpty:Boolean=false;
  addCategory(){
   if(this.categoryData.title!=""&&this.categoryData.description!=""){
    // false the empty error 
    this,this.allFieldsEmpty=false;
    this.titleFieldEmpty=false;
    this.descriptionFieldEmpty=false;
    // post the category data in backend
      this.categoryService.addCategory(this.categoryData).subscribe(
        (response:any)=>{
          if(response.categoryisAdded){
            this.categoryData.title="";
            this.categoryData.description="";
            this.router.navigateByUrl("/admin/show-category");

          }
        },
        (err:any)=>
        {console.log(err)}
      )
   }else{
    if(this.categoryData.title==""&&this.categoryData.description==""){
      this.allFieldsEmpty=true;
    }
    else{
      this.allFieldsEmpty=false;
      if(this.categoryData.title==""){this.titleFieldEmpty=true}else{this.titleFieldEmpty=false}
      if(this.categoryData.description==""){this.descriptionFieldEmpty=true}else{this.descriptionFieldEmpty=false}
    }
   }

  }
}
