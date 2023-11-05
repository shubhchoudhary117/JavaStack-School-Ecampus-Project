import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-doemail',
  templateUrl: './doemail.component.html',
  styleUrls: ['./doemail.component.css']
})
export class DoemailComponent implements OnInit{
  ngOnInit(){

  }

  // declare the form validation variables
  validation={
    toIsRequired:false,
    subjectIsRequired:false,
    descriptionIsRequired:false,
    allFieldsIsEmpty:false
  }
  // declare the form handler data object
  emailData:any={
    to:"",
    subject:"",
    description:""
  }

  // send the mail after submit form 
  sendMail(){
    // validate the fields
    if(this.emailData.to!=""&&this.emailData.subject!=""&&this.emailData.description!=""){

      // false the validation errors
      this.validation.allFieldsIsEmpty=false;
      this.validation.toIsRequired=false;
      this.validation.subjectIsRequired=false;
      this.validation.descriptionIsRequired=false;
      // after everything is ok so send mail
      Swal.fire({
        icon: 'success',
        title: 'your message sent successfully',
        showConfirmButton: false,
        timer: 1500
      })
      // clear the form 
      this.emailData.to=""
      this.emailData.subject=""
      this.emailData.description=""
    }else{
      if(this.emailData.to==""&&this.emailData.subject==""&&this.emailData.description==""){
        this.validation.allFieldsIsEmpty=true;
      }else{
        this.validation.allFieldsIsEmpty=false;
        if(this.emailData.to==""){this.validation.toIsRequired=true}else{this.validation.toIsRequired=false}
        if(this.emailData.subject==""){this.validation.subjectIsRequired=true}else{this.validation.subjectIsRequired=false}
        if(this.emailData.description==""){this.validation.descriptionIsRequired=true}else{this.validation.descriptionIsRequired=false}
      }
    }
  }
}
