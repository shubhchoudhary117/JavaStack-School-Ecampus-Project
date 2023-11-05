import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/QuizeService/question.service';

@Component({
  selector: 'app-showquestions',
  templateUrl: './showquestions.component.html',
  styleUrls: ['./showquestions.component.css']
})
export class ShowquestionsComponent implements OnInit{
  constructor(private activatedRouter:ActivatedRoute,private questionService:QuestionService){}
  // declare some data object
  
  quizeId:any;
  // declare array for storing questions
  AllQuestions:any=[]
  ngOnInit(){
    // access the paramaeters from url
   let id=this.activatedRouter.snapshot.params['id'];
   this.quizeId=id;
  //  get all question from sended id 
    this.questionService.getQuestions(id).subscribe(
      (response:any)=>{
        console.log(response)
        this.AllQuestions=response;
      },
      (err:any)=>{
        console.log(err)
      }
    )
  }

}
