import { Component, OnInit } from '@angular/core';
import { QuizeService } from 'src/app/services/QuizeService/quize.service';

@Component({
  selector: 'app-showquizes',
  templateUrl: './showquizes.component.html',
  styleUrls: ['./showquizes.component.css']
})
export class ShowquizesComponent implements OnInit{
  constructor(private quizeService:QuizeService){}
  // declare the data object
  QuizeData:any=[];
  ngOnInit() {
    // get all quizes from backend api
    this.quizeService.getQuizes().subscribe(
      (response:any)=>{
        console.log(response)
        this.QuizeData=response.quizes;
      },
      (err:any)=>{
        console.log(err)
      }
    )
  }

 
  // delete quize
  doDeleteQuize(id:any){
    // call delete quize api
    this.quizeService.deleteQuize(id).subscribe(
      (response:any)=>{
        console.log(response)
      },
      (err:any)=>{
        console.log(err);
      }
    )
  }

}
