import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SignupService } from 'src/app/services/signup.service';

@Component({
  selector: 'app-signeup',
  templateUrl: './signeup.component.html',
  styleUrls: ['./signeup.component.css']
})
export class SigneupComponent  implements OnInit{
   ngOnInit(): void {
     
   }
   constructor(private service:SignupService,private router:Router){}

  //  fomr handler objects
  Signer={
    name:"",
    email:"",
    password:"",
    cpassword:""

  }
  // declare the form handler variables
  nameIsEmpty:Boolean=false;
  emailIsEmpty:Boolean=false;
  passwordIsEmpty:Boolean=false;
  cpasswordIsEmpty:Boolean=false;
  allFieldsEmpty:Boolean=false;

  // declare the post request response handler variabl
  emailIsAlreadyExist:Boolean=false;
  //  envent methods
  doSignup(){
   if(this.Signer.name!=""&&this.Signer.email!=""&&this.Signer.password!=""&&this.Signer.cpassword!=""){
    if(this.Signer.password==this.Signer.cpassword){
      // if everything is ok then post the signup request in backend
      this.service.postSignup(this.Signer)
      // handle the response
      .subscribe((response:any)=>{
        // set the email is already exis error message
        this.emailIsAlreadyExist=response.emailIsAlreadyExist;
        // clear the input fields after submit form and signup success
        if(!this.emailIsAlreadyExist){
          this.Signer.name=""
          this.Signer.email=""
          this.Signer.password=""
          this.Signer.cpassword=""
          // redirect on login page
          this.router.navigateByUrl('/login')
        }

      },
      (err)=>{console.log(err)
      })


    }else{
      this.cpasswordIsEmpty=true;
    }
   }
   else{
      if(this.Signer.name==""&&this.Signer.email==""&&this.Signer.password==""&&this.Signer.cpassword==""){
        this.allFieldsEmpty=true;
      }
      else{
        this.allFieldsEmpty=false;
        if(this.Signer.name==""){this.nameIsEmpty=true}else{this.nameIsEmpty=false}
        if(this.Signer.email==""){this.emailIsEmpty=true}else{this.emailIsEmpty=false}
        if(this.Signer.password==""){this.passwordIsEmpty=true}else{this.passwordIsEmpty=false}
        if(this.Signer.cpassword==""){this.cpasswordIsEmpty=true}else{this.cpasswordIsEmpty=false}
      }
   }
   }
}
