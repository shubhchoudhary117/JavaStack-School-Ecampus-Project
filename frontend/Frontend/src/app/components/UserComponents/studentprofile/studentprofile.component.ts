import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { StudentprofileService } from 'src/app/services/EcampusServices/StudentProfileServices/studentprofile.service';
import { StudentreletedService } from 'src/app/services/StudentServices/studentreleted.service';
import { TokenService } from 'src/app/services/token.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-studentprofile',
  templateUrl: './studentprofile.component.html',
  styleUrls: ['./studentprofile.component.css']
})
export class StudentprofileComponent implements OnInit {

  constructor(private profileService: StudentprofileService, private tokenService: TokenService,
    private StudentService:StudentreletedService,
    private spinner: NgxSpinnerService) { }
    
    // create variables for loader animatins
    activeLoader: boolean = false;
    spinnerName: any;
    spinnerType: any;

  ngOnInit() {
    this.getStudentProfileDetails();

  }

  template: any;
  closeEditeTemplate() {
    this.template = document.getElementById("edite-template")
    this.template.style.top = "-100%";

  }
  // open the edite profile template
  openEditeProfileTemplate() {
    this.template = document.getElementById("edite-template")
    this.template.style.top = "95%";
  }

   // get student profile details from call api
   StudentDetails: any;


    
  getStudentProfileDetails() {

    // call the profile service
    this.profileService.getStudentProfile(this.tokenService.getToken()).subscribe(
      (response: any) => {
        console.log(response)
        // check student and set details
        if (!response.studetnNotPrasent) {
          this.StudentDetails = response.student;
        }
      },
      (err: any) => {
        console.log(err)
      }
    )
  }
  // end of getting student profile details function

  // define the profile details object
  detailsObj: any = {
    email: "",
    mobile: "",
    category: "",
    birthdate: "",
    gender: "",
    address: "",
    village: ""
  }

  // validation obje
  formValidation: any = {
    nameFieldEmpty: false,
    emailFieldEmpty: false,
    mobileFieldEmpty: false,
    birthdateFieldEmpty: false,
    genderFieldEmpty: false,
    categoryFieldEmpty: false,
    addressFieldEmpty: false,
    villageFieldEmpty: false,
    allFieldsIsEmpty: false

  }



  // start the update user function 
  doUpdateStudentProfile() {
    console.log(this.detailsObj)
    if (this.detailsObj.email != "" && this.detailsObj.mobile != "" &&this.detailsObj.birthdate != ""
     && this.detailsObj.category != "" && this.detailsObj.gender != ""
      && this.detailsObj.village != "" && this.detailsObj.address != "") {
       
        // update the formvalidation 
      // this.formValidation.allFieldsIsEmpty=false;
      // after everything is ok
        
      // create an object
      let updatingDetails={
        studentname:this.StudentDetails.fullname,
        enrollment:this.StudentDetails.enrollment,
        email:this.detailsObj.email,
        mobile:this.detailsObj.mobile,
        birthdate:this.detailsObj.birthdate,
        category:this.detailsObj.category,
        gender:this.detailsObj.gender,
        village:this.detailsObj.village,
        address:this.detailsObj.address
      }
        // call the api
        this.StudentService.doUpdateProfileApi(updatingDetails).subscribe(
          (response:any)=>{
            console.log(response)
            // if update successfully then fire success popup
            if(response.updateSuccessfully){
              Swal.fire({
                position: 'center',
                icon: 'success',
                title: 'Your work has been saved',
                showConfirmButton: false,
                timer: 1500
              })
              // clear the fields
              this.detailsObj.email=""
              this.detailsObj.mobile=""
              this.detailsObj.village=""
              this.detailsObj.category=""
              this.detailsObj.gender=""
              this.detailsObj.address=""
              this.detailsObj.birthdate=""

              // go to the page
              this.closeEditeTemplate();
              this.getStudentProfileDetails();
            }
            // if something went wrong then fire popup
            if(response.somethingWentwrong){
              Swal.fire({
                position:'center',
                icon: 'error',
                title: 'Oops...',
                text: 'Something went wrong!',
                footer: '<a href="">Why do I have this issue?</a>'
              })
            }
          },
          (error:any)=>{
            console.log(error)
          }
        )

    } else {
      if (this.detailsObj.fullname == "" && this.detailsObj.email == "" && this.detailsObj.mobile == "" &&
        this.detailsObj.birthdate == "" && this.detailsObj.category == "" && this.detailsObj.gender == ""
        && this.detailsObj.village == "" && this.detailsObj.address == "") {
        this.formValidation.allFieldsIsEmpty = true;
      } else {
        this.formValidation.allFieldsIsEmpty = false;
        if (this.detailsObj.fullname == "") { this.formValidation.nameFieldEmpty = true }
        else { this.formValidation.nameFieldEmpty = false }
        if (this.detailsObj.email == "") { this.formValidation.emailFieldEmpty = true }
        else { this.formValidation.emailFieldEmpty = false }
        if (this.detailsObj.mobile == "") { this.formValidation.mobileFieldEmpty = true }
        else { this.formValidation.mobileFieldEmpty = false }
        if (this.detailsObj.birthdate == "") { this.formValidation.birthdateFieldEmpty = true }
        else { this.formValidation.birthdateFieldEmpty = false }
        if (this.detailsObj.category == "") { this.formValidation.categoryFieldEmpty = true }
        else { this.formValidation.categoryFieldEmpty = false }
        if (this.detailsObj.gender == "") { this.formValidation.genderFieldEmpty = true }
        else { this.formValidation.genderFieldEmpty = false }
        if (this.detailsObj.village == "") { this.formValidation.villageFieldEmpty = true }
        else { this.formValidation.villageFieldEmpty = false }
        if (this.detailsObj.address == "") { this.formValidation.addressFieldEmpty = true }
        else { this.formValidation.addressFieldEmpty = false }
      }
    }
  }
  // end of update function

}
