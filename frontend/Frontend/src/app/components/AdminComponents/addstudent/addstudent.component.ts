import { Component, OnInit } from '@angular/core';
import { AddStudentServiceService } from 'src/app/services/adminservices/add-student-service.service';
import { CommanStudentServiceService } from 'src/app/services/CommanServices/comman-student-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addstudent',
  templateUrl: './addstudent.component.html',
  styleUrls: ['./addstudent.component.css']
})
export class AddstudentComponent implements OnInit{

  public userfile:any=File;

  constructor(private adminServices:AddStudentServiceService,private commanService:CommanStudentServiceService){}

  ngOnInit() {
  //  call the availabe classes function for get all classes info when availabe in institute
    this.getAvailabelClasses();
  }

  // get all categories of institute heighes classes
  availableClasses:any=[]
  getAvailabelClasses(){
    // call the api
    this.commanService.getStudentClassCategory().subscribe(
      (response:any)=>{
        this.availableClasses=response.availableClasses;
        console.log(response)
      },
      (error:any)=>{
        console.log(error)
      }
    )
  }

  // declare the form handler data object
  studentData:any={
    studentname:"",
    fathername:"",
    mothername:"",
    enrollment:"",
    mobile:"",
    village:"",
    birthdate:"",
    addmissionyear:"",
    classname:"",
    schooltype:"",
    category:"",
    midium:"",
    email:"",
    address:"",
    gender:"",
    studentCategory:{
      scid:""
    }
  }

  // declare the validation errors object
  formValidation={
    studentnameFieldIsEmpty:false,
    fathernameFieldIsEmpty:false,
    mothernameFieldIsEmpty:false,
    mobileFieldIsEmpty:false,
    enrollmentFieldIsEmpty:false,
    villageFieldIsEmpty:false,
    birthdateFieldIsEmpty:false,
    addmissionyearFieldIsEmpty:false,
    classnameFieldIsEmpty:false,
    schooltypeFieldIsEmpty:false,
    categoryFieldIsEmpty:false,
    midiumFieldIsEmpty:false,
    emailFieldIsEmpty:false,
    addressFieldIsEmpty:false,
    genderFieldIsEmpty:false,
    allFieldsIsEmpty:false

  }

  // get the file
  getFile(e:any){
    console.log(e.target.files)
    let file=e.target.files[0]
    this.userfile=file
  }

  

  // declare the form submitions function
  doAddStudent(){
    if(this.studentData.studentname!=""&&this.studentData.fathername!=""&&this.studentData.mothername!=""
    &&this.studentData.enrollment!=""&&this.studentData.mobile!=""&&this.studentData.village!=""&&
    this.studentData.birthdate!=""&&this.studentData.addmissionyear!=""&&this.studentData.class!=""&&
    this.studentData.schooltype!=""&&this.studentData.category!=""&&this.studentData.midium!=""&&
    this.studentData.email!=""&&this.studentData.address!="",this.studentData.gender!=""){

      // update the validation object
      this.formValidation.allFieldsIsEmpty=false;
      this.formValidation.studentnameFieldIsEmpty=false;
      this.formValidation.fathernameFieldIsEmpty=false;
      this.formValidation.mothernameFieldIsEmpty=false;
      this.formValidation.mobileFieldIsEmpty=false;
      this.formValidation.enrollmentFieldIsEmpty=false;
      this.formValidation.villageFieldIsEmpty=false;
      this.formValidation.birthdateFieldIsEmpty=false;
      this.formValidation.addmissionyearFieldIsEmpty=false;
      this.formValidation.classnameFieldIsEmpty=false;
      this.formValidation.schooltypeFieldIsEmpty=false;
      this.formValidation.categoryFieldIsEmpty=false;
      this.formValidation.midiumFieldIsEmpty=false;
      this.formValidation.emailFieldIsEmpty=false;
      this.formValidation.addmissionyearFieldIsEmpty=false;
      this.formValidation.genderFieldIsEmpty=false;

     
    

      // if everything is ok then call the api and send the student data
      this.adminServices.addNewStudent(this.studentData).subscribe(
        (response:any)=>{
          if(response.studentAddedSuccessfully){
            // fire the success popup box
            Swal.fire({
              position: 'center',
              icon: 'success',
              title: 'student added successfully',
              showConfirmButton: false,
              timer: 1500
            })
            // than after the clear the form
            this.studentData.studentname="";this.studentData.fathername="";this.studentData.mothername="";
            this.studentData.mobile="";this.studentData.enrollment="";this.studentData.village="";
            this.studentData.birthdate="";this.studentData.addmissionyear="";this.studentData.classname="";
            this.studentData.category="";this.studentData.midium="";this.studentData.gender="";
            this.studentData.email="";this.studentData.address="";this.studentData.schooltype="";
          }
          if(response.somethingWentWrong){
            // fire the something went wrong error message
            Swal.fire({
              position:"center",
              icon: 'error',
              title: 'Oops...',
              text: 'Something went wrong!',
              footer: '<p>something went worng please check student form than submit again</p>'
            })
          }
        },
        (error:any)=>{
          Swal.fire({
            position:"center",
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!',
            footer: '<p>something went worng please check student form than submit again</p>'
          })
        }
      )
    }else{
      // check all field
      if(this.studentData.studentname==""&&this.studentData.fathername==""&&this.studentData.mothername==""
      &&this.studentData.enrollment==""&&this.studentData.mobile==""&&this.studentData.village==""&&
      this.studentData.birthdate==""&&this.studentData.addmissionyear==""&&this.studentData.classname==""&&
      this.studentData.schooltype==""&&this.studentData.category==""&&this.studentData.midium==""&&
      this.studentData.email==""&&this.studentData.address==""&&this.studentData.gender==""){
        // update the form validation object
        this.formValidation.allFieldsIsEmpty=true;
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'All fields is required!',
          footer: '<p >fill all the fields than after submit the form </p>'
        })

      }else{
        if(this.studentData.studentname==""){this.formValidation.studentnameFieldIsEmpty=true}
        else{this.formValidation.studentnameFieldIsEmpty=false}
        if(this.studentData.fathername==""){this.formValidation.fathernameFieldIsEmpty=true}
        else{this.formValidation.fathernameFieldIsEmpty=false}
        if(this.studentData.mothername==""){this.formValidation.mothernameFieldIsEmpty=true}
        else{this.formValidation.mothernameFieldIsEmpty=false}
        if(this.studentData.enrollment==""){this.formValidation.enrollmentFieldIsEmpty=true}
        else{this.formValidation.enrollmentFieldIsEmpty=false}
        if(this.studentData.mobile==""){this.formValidation.mobileFieldIsEmpty=true}
        else{this.formValidation.mobileFieldIsEmpty=false}
        if(this.studentData.village==""){this.formValidation.villageFieldIsEmpty=true}
        else{this.formValidation.villageFieldIsEmpty=false}
        if(this.studentData.birthdate==""){this.formValidation.birthdateFieldIsEmpty=true}
        else{this.formValidation.birthdateFieldIsEmpty=false}
        if(this.studentData.addmissionyear==""){this.formValidation.addmissionyearFieldIsEmpty=true}
        else{this.formValidation.addmissionyearFieldIsEmpty=false}
        if(this.studentData.classname==""){this.formValidation.classnameFieldIsEmpty=true}
        else{this.formValidation.classnameFieldIsEmpty=false}
        if(this.studentData.schooltype==""){this.formValidation.schooltypeFieldIsEmpty=true}
        else{this.formValidation.schooltypeFieldIsEmpty=false}
        if(this.studentData.category==""){this.formValidation.categoryFieldIsEmpty=true}
        else{this.formValidation.categoryFieldIsEmpty=false}
        if(this.studentData.midium==""){this.formValidation.midiumFieldIsEmpty=true}
        else{this.formValidation.midiumFieldIsEmpty=false}
        if(this.studentData.email==""){this.formValidation.emailFieldIsEmpty=true}
        else{this.formValidation.emailFieldIsEmpty=false}
        if(this.studentData.address==""){this.formValidation.addressFieldIsEmpty=true}
        else{this.formValidation.addressFieldIsEmpty=false}
        if(this.studentData.gender==""){this.formValidation.genderFieldIsEmpty=true}
        else{this.formValidation.genderFieldIsEmpty=false}
      }
    }
  }
}
