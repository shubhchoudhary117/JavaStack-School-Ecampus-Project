import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  constructor(){}
  ngOnInit() {
  }
  // declare the logerdata object
  logerData:any={
    email:"",
    password:""
  }

  emailFieldEmpty:Boolean=false;
  passwordFieldEmpty:Boolean=false;
  allFieldEmpty:Boolean=false;
  btn:any;
  doLogin(){
    if(this.logerData.email!=""&&this.logerData.password!=""){
      this.allFieldEmpty=false;
      this.emailFieldEmpty=false;
      this.passwordFieldEmpty=false;

      this.btn=document.getElementById("login-btn")
      this.btn.style.transform="translateX(0px)"
      
    }
    else{
      if(this.logerData.email==""&&this.logerData.password==""){
        this.allFieldEmpty=true;
        
      this.btn=document.getElementById("login-btn")
      this.btn.style.transform="translateX(300px)"
      }else{
        this.allFieldEmpty=false
        if(this.logerData.email==""){this.emailFieldEmpty=true}else{this.emailFieldEmpty=false}
        if(this.logerData.password=""){this.passwordFieldEmpty=true}else{this.passwordFieldEmpty=false}
      }
    }
  }

}
