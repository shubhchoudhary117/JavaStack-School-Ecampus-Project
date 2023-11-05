import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit{
  constructor(private loginService:LoginService,private router:Router){}
  // create capthc variabel
  captcha:any;
  ngOnInit(){
    this.reloadCaptcha();
  }
   reloadCaptcha(){
    var generatedCaptcha="";
    var RandomChar="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    for(let i=0;i<=5;i++){
      generatedCaptcha+=RandomChar.charAt(Math.random()*RandomChar.length);
    }
    // set the captcha
    this.captcha=generatedCaptcha;
   }
  //  after reloading captcha

  // create form data object
  loginData:any={
    username:"",
    password:"",
    captcha:""
  }
  // declare the login form validation variabels
  usernameFieldEmpty:Boolean=false;
  passwordFieldEmpty:Boolean=false;
  captchaFieldEmpty:Boolean=false;
  allFieldsEmpty:Boolean=false;
  // form handler code
  doLogin(){
    if(this.loginData.username!=""&&this.loginData.password!=""&&this.loginData.captcha!=""){
         // false all validation
         this.allFieldsEmpty=false;
         this.usernameFieldEmpty=false;
         this.passwordFieldEmpty=false;
         this.captchaFieldEmpty=false;
      if(this.loginData.captcha==this.captcha){
      // after everything is ok then post request
      let LogerInfo={
        username:this.loginData.username,
        password:this.loginData.password
      }
      // call the api 
      this.loginService.doLogin(LogerInfo).subscribe(
        (response:any)=>{
          console.log(response)
        //  set errors
          if(response.usernameNotExist){
            Swal.fire({
              icon: 'error',
              title: 'please check...',
              text: 'username is invalid !',
            }) 
          }
          if(response.passwordIsNotExist){
            Swal.fire({
              icon: 'error',
              title: 'please check...',
              text: 'invalid cradintals!',
            }) 
          }
          // after everythis is ok than set the toke
          if(response.loginSuccess&&response.token!=null){
            this.loginService.setToken(response.token);
            this.router.navigateByUrl("/student/dashboard")
            
          }
        },
        (err:any)=>{
          console.log(err)
        }
      )
      }else{
        Swal.fire({
          icon: 'error',
          title: 'please check...',
          text: 'captcha is invalid !',
        }) 
      }
    
    }
    else{
      if(this.loginData.username==""&&this.loginData.password==""&&this.loginData.captcha==""){
        this.allFieldsEmpty=true;
      }else{
        this.allFieldsEmpty=false;
        if(this.loginData.username==""){this.usernameFieldEmpty=true}else{this.usernameFieldEmpty=false}
        if(this.loginData.password==""){this.passwordFieldEmpty=true}else{this.passwordFieldEmpty=false}
        if(this.loginData.captcha==""){this.captchaFieldEmpty=true}else{this.captchaFieldEmpty=false}
      }
    }
  }
}
