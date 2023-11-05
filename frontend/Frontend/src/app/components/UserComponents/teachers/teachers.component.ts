import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { TeacherServicesService } from 'src/app/services/TeachersServices/teacher-services.service';

@Component({
  selector: 'app-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css']
})
export class TeachersComponent implements OnInit {
  constructor(private teacherService: TeacherServicesService,
    private spinner: NgxSpinnerService,private router:Router) { }

  // declare the teacher details object
  teachers: any = [];
  activeLoader: boolean = false;
  spinnerName: any;
  spinnerType: any;

  ngOnInit() {
      this.loadAllTeachers();

  }

  loadAllTeachers() {
    // call the services
    this.teacherService.getTeacherDetails().subscribe(
      (response: any) => {
        this.teachers = response;
        console.log(this.teachers)
      },
      (error: any) => {
        // if(error.statusText==="Unknown Error"){
        //   this.router.navigateByUrl("revaecampus/login")
        // }
        console.log(error)
      }
    )
  }


  // end of calling teachers details api
  searchByTeacherName() {
    this.teacherService.getTeacherByTeacherName("paras").subscribe(
      (response: any) => {
        console.log(response)
      },
      (error: any) => {
        console.log(error)
      }
    )
  }

}
