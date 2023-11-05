import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/QuizeService/question.service';
import { QuizeService } from 'src/app/services/QuizeService/quize.service';
import { NgxSpinnerService } from "ngx-spinner";
import { LocationStrategy } from '@angular/common';
import { browser } from 'jodit/types/core/helpers';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-quizequestions',
  templateUrl: './quizequestions.component.html',
  styleUrls: ['./quizequestions.component.css']
})
export class QuizequestionsComponent implements OnInit {
  spinnerType:string="";
  timer:any=3;
  spinnerName:string="";
  constructor(private locationStrategy:LocationStrategy,private spinner:NgxSpinnerService,private activatedRouter: ActivatedRoute, private questionService: QuestionService) {
   }
  // declare some important variables
  quize_id: any;
  // this ngOnint functin call on component load
 
   activeLoader:boolean=false;
  startTest:boolean=false;
  ngOnInit() {

    setTimeout(() => {
      this.startTest=true;
    }, 5000);

    // get the quize id
    this.quize_id = this.activatedRouter.snapshot.params['quize_id']
    // loader animation 
    this.spinnerName = "sp1";
    this.spinnerType = "ball-atom";
    this.spinner.show(this.spinnerName);
    this.activeLoader=true;

    setTimeout(() => {
      this.activeLoader=false;
      this.spinner.hide(this.spinnerName);
       // call the load question function
    this.loadAllQuestionsFromChoosedQuize();

    }, 5000)

     
    // block the prevent page history
    this.preventBackBlock();

    // call the function 
    this.windowIsMinimized()
  }

  // block the previous page navigation
  preventBackBlock(){
    history.pushState(null,"",window.location.href);
    this.locationStrategy.onPopState(()=>{
      history.pushState(null,"",window.location.href);
    }); 
  }

  // if window is minimized than submit test automatically
  userIsInteracting:boolean=false;
  userInteractOtherPlaceCounter:any=0;
  windowIsMinimized(){
    document.addEventListener("visibilitychange", () => {
      if (document.visibilityState === 'visible') {
        this.userIsInteracting=false;
       
      } else {
        this.userIsInteracting=true;
        this.userInteractOtherPlaceCounter+=1;
        if(this.userInteractOtherPlaceCounter==3){
          Swal.fire({
            color:"red",
            
            title: ' You have interacted on other places 3 times, now if you do then the test will be submitted automatically.',
            showClass: {
              popup: 'animate__animated animate__fadeInDown'
            },
            hideClass: {
              popup: 'animate__animated animate__fadeOutUp'
            }
          })
        }
        else if(this.userInteractOtherPlaceCounter>3){
          this.quizeSubmited=true;
        }
      }
    });
  }


  // define some variable
  quizeSubmited: Boolean = false;
  // defint an arrya for containing questions
  questions: any = []
  // call the api for load the all question from choosed quize
  loadAllQuestionsFromChoosedQuize() {
    // call the api
    this.questionService.getQuestions(this.quize_id).subscribe(
      (response: any) => {
        console.log(response)
        this.questions = response;

        // push the new propertie
        this.questions.forEach((que: any) => {
          que['givenAnswer'] = ''
        })
      },
      (error: any) => {
        console.log(error)
      }
    )
  }

  // end of question loading function
  totalRights: any = 0;
  totalAttemp: any = 0;
  wrongAns: any = 0;
  totalQuestions: any = 0;
  studentScore: any = 0;
  studentPoints: any = 0;
  studentIsFail: boolean = false;
  studentIsPass: Boolean = false;
  studentIsExcelentPass: Boolean = false;
  Fail: Boolean = false;
  Pass: Boolean = false;
  doSubmitExam() {

    // check the question attem and right questions
    this.questions.forEach((question: any) => {
      this.totalQuestions++;
      if (question.givenAnswer != "") {
        this.totalAttemp++;
        if (question.givenAnswer == question.answer) {
          this.studentPoints += 4;
        } else {
          this.wrongAns++;
        }
      }
    })
    // end of forEach function

    if (this.studentPoints >= 65) {
      this.studentIsExcelentPass = true;
      this.Pass=true;
      this.Fail=false;
    } else {
      if (this.studentPoints >= 32 && this.studentPoints < 65) {
        this.studentIsPass = true;
        this.studentIsFail = false;
        this.studentIsExcelentPass = false;
        this.Pass=true;
        this.Fail=false;
      } else {
        this.studentIsPass = false;
        this.studentIsFail = true;
        this.studentIsExcelentPass = false;
        this.Fail=true;
        this.Pass=false;
      }
    }

    // evaluate the result for passing students
    // if(this.studentPoints>=32&&this.studentPoints<65){
    //   this.studentIsPass=true;
    //   this.studentIsFail=false;
    // }else{
    //   this.studentIsFail=true;
    //   this.studentIsPass=false;
    // }

    // // evaluate the result for excellent students
    // if(this.studentPoints>=65){
    //   this.studentIsExcelent=true;

    // }else{
    //   this.studentIsExcelent=false;
    // }

    this.quizeSubmited = true;
    // display the resule


  }



}
