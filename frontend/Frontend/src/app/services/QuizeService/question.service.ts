import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuestionService implements OnInit{

  constructor(private http:HttpClient) { }
  ngOnInit(){
  }
  // set the url
  questionUrl:any="http://localhost:7070/question"

  // add question
  addQuestion(questionData:any){
    return this.http.post(`${this.questionUrl}/addquestion`,questionData);
  }

  // for get all question from matching this id
  
  // get all questions
  getQuestions(quzeId:any){
    return this.http.get(`${this.questionUrl}/getquestions/${quzeId}`)
  }



}
