import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { QuestionService } from 'src/app/services/QuizeService/question.service';

@Component({
  selector: 'app-addquestions',
  templateUrl: './addquestions.component.html',
  styleUrls: ['./addquestions.component.css']
})
export class AddquestionsComponent implements OnInit{

  constructor(private questionService:QuestionService,private activatedRouter:ActivatedRoute,private router:Router){}
  // set the quize id 
  quizeId:any=0;
  ngOnInit(){
   
    let id=this.activatedRouter.snapshot.params['id'];
    this.quizeId=id;
  }

  // declare the form handler data objec
  questionData:any={
    content:"",
    option1:"",
    option2:"",
    option3:"",
    option4:"",
    answer:"",
  }
  // declare validation variables
  allFieldsEmpty:Boolean=false;
  contentFieldEmpty:Boolean=false;
  option1FieldEmpty:Boolean=false;
  option2FieldEmpty:Boolean=false;
  option3FieldEmpty:Boolean=false;
  option4FieldEmpty:Boolean=false;
  answerFieldEmpty:Boolean=false;

  submitQuestion(){
    if(this.questionData.content!=""&&this.questionData.option1!=""&&this.questionData.option2!=""&&this.questionData.option3!=""&&this.questionData.option4!=""&&this.questionData.answer!=""){
      // false all error
      this.allFieldsEmpty=false;
      this.contentFieldEmpty=false;
      this.option1FieldEmpty=false;
      this.option2FieldEmpty=false;
      this.option3FieldEmpty=false;
      this.option4FieldEmpty=false;
      this.answerFieldEmpty=false;

      // if everything is ok so post the question data 
      // create perfect api data
     let  QuestionData={
        content:this.questionData.content,
        option1:this.questionData.option1,
        option2:this.questionData.option2,
        option3:this.questionData.option3,
        option4:this.questionData.option4,
        answer:this.questionData.answer,
        quize:{
          qid:this.quizeId
        }
      } 
      console.log(QuestionData)
      this.questionService.addQuestion(QuestionData).subscribe(
        (response:any)=>{
          console.log(response)
          if(response.questionIsAdded){
            this.questionData.content="";
            this.questionData.option1="";
            this.questionData.option2="";
            this.questionData.option3="";
            this.questionData.option4="";
            this.questionData.answer=""
            // navigate the show question page
            this.router.navigateByUrl("/admin/show-questions/"+this.quizeId)
          }else{
            alert("not added")
          }
        },
        (err:any)=>{
          console.log(err)
        }
      )
      
    }
    else{
      if(this.questionData.content==""&&this.questionData.option1==""&&this.questionData.option2==""&&this.questionData.option3==""&&this.questionData.option4==""&&this.questionData.answer==""){
      this.allFieldsEmpty=true;
      }
      else{
        this.allFieldsEmpty=false;
        if(this.questionData.content==""){this.contentFieldEmpty=true}else{this.contentFieldEmpty=false}
        if(this.questionData.option1==""){this.option1FieldEmpty=true}else{this.option1FieldEmpty=false}
        if(this.questionData.option2==""){this.option2FieldEmpty=true}else{this.option2FieldEmpty=false}
        if(this.questionData.option3==""){this.option3FieldEmpty=true}else{this.option3FieldEmpty=false}
        if(this.questionData.option4==""){this.option4FieldEmpty=true}else{this.option4FieldEmpty=false}
      }
    }
  }

}
