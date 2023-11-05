import { identifierName } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { TeacherServicesService } from 'src/app/services/TeachersServices/teacher-services.service';

@Component({
  selector: 'app-aboutteacher',
  templateUrl: './aboutteacher.component.html',
  styleUrls: ['./aboutteacher.component.css']
})
export class AboutteacherComponent implements OnInit {
  constructor(private acitvatedRoute: ActivatedRoute,
    private teacherService: TeacherServicesService,
    private spinner: NgxSpinnerService) { }
  // declaration of variables
  Teacher: any;
  start: any = 0;
  deg: any = 360;
  rank: any = 50
  progressBar: any;
  activeLoader: boolean = false;
  spinnerName: any;
  spinnerType: any;

  // call ngOnit function during load component and change anything in component
  ngOnInit() {
    let teacher_id = this.acitvatedRoute.snapshot.params['tid']

    this.spinnerName = "sp1";
    this.spinnerType = "ball-atom";
    this.activeLoader = true;
    this.spinner.show(this.spinnerName);

    setTimeout(() => {
      this.activeLoader = false;
      this.spinner.hide(this.spinnerName);
      // call the getTeacherdetails By id function
      this.getTeacherById(teacher_id);
    }, 3000);

  }

  // call the api for get teachr data for this identifierName
  getTeacherById(teacher_id: any) {

    // call the api
    this.teacherService.getTeacherByTeacherId(teacher_id).subscribe(
      (response: any) => {
        console.log(response)
        this.Teacher = response.teacherDetails;
      }
      ,
      (error: any) => {
        console.log(error)

      }
    )
    // end of calling api
    // call the animation functin
    this.profileRankingAnimation();

  }

  // some animatins code

  profileRankingAnimation() {
    this.progressBar = document.getElementById("progress-circular")

    let intervalObj = setInterval(() => {
      this.start++;
      this.progressBar.style.background = `conic-gradient(#3D5EE1 ${this.start}%,#ededed 0deg)`;
      if (this.start == this.rank) {
        clearInterval(intervalObj)
      }
    })
  }




}
