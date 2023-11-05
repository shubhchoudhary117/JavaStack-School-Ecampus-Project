import { Token } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  ngOnInit(): void {
    
  }

  constructor(private service:LoginService,private router:Router){}



  //  fomr handler objects
  Loger={

    email:"",
    password:"",

  }
  // declare the form handler variables
  emailIsEmpty:Boolean=false;
  passwordIsEmpty:Boolean=false;
  allFieldsEmpty:Boolean=false;
  loginSuccess:Boolean=false;
  jwtToken:any=null;
  // declare the post request response handler variabl
  emailIsNotExist:Boolean=false;
  passwordIsInvalid:Boolean=false;
  //  envent methods
  doLogin(){
   if(this.Loger.email!=""&&this.Loger.password!=""){
    //update form error handler fields
    this.allFieldsEmpty=false
    this.emailIsEmpty=false
    this.passwordIsEmpty=false
    // post the login request
      this.service.doLogin(this.Loger).subscribe(
        (response:any)=>{
          this.emailIsNotExist=response.emailIsNotExist
          this.passwordIsInvalid=response.passwordIsNotExist
          this.loginSuccess=response.loginSuccess
          this.jwtToken=response.token;
          // set the token in localstorage
          if(this.jwtToken!=null){
            this.setToken(this.jwtToken)
          }
          if(this.loginSuccess){
            this.Loger.email=""
            this.Loger.password=""
            this.router.navigateByUrl('/dashboard')
          }
        },
        (err)=>{
          console.log(err)
        }
      )
   }
   else{
      if(this.Loger.email==""&&this.Loger.password==""){
        this.allFieldsEmpty=true;
      }
      else{
        this.allFieldsEmpty=false;
        if(this.Loger.email==""){this.emailIsEmpty=true}else{this.emailIsEmpty=false}
        if(this.Loger.password==""){this.passwordIsEmpty=true}else{this.passwordIsEmpty=false}
      }
   }


  }
  // set the jwt token in localstorage
  setToken(token:any){
    localStorage.setItem('token',token);
    return true;
  }



}
