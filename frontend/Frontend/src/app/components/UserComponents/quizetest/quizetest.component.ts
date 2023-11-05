import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { QuizeService } from 'src/app/services/QuizeService/quize.service';

@Component({
  selector: 'app-quizetest',
  templateUrl: './quizetest.component.html',
  styleUrls: ['./quizetest.component.css']
})
export class QuizetestComponent implements OnInit{
  constructor(private quizeService:QuizeService,private spinner:NgxSpinnerService){}



  ngOnInit(){
    // call the function and get and set all quizes
    this.getAllQuizes();
  }

  // create the conditions hadler variables
  NotQuizesAvailable:Boolean=true;
  // create the quizes array
  Quizes:any=[];
  getAllQuizes(){

    // call the api
    this.quizeService.getQuizes().subscribe(
      (response:any)=>{
        console.log(response)
        // set the quizes array
        this.Quizes=response.quizes;
       
        // set the not quize available variable
        if(this.Quizes==null){
          this.NotQuizesAvailable=true;
        }else{
          this.NotQuizesAvailable=false;
        }
      },
      (error:any)=>{
        console.log(error)
      }
    )
  }

}
