import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtauthenticationService } from 'src/app/services/jwtauthentication.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  ngOnInit(){
    this.checkAuthorizationPermissions();

  }
  // constructor
  constructor(private service:JwtauthenticationService,private tokenService:TokenService,private route:Router){}
  // create jwt token details object
 tokenDetails={
    token:this.tokenService.getToken()
  }
  // set token details variables
  tokenIsValidated:Boolean=false;
  userIsAuthenticated:Boolean=false;

  checkAuthorizationPermissions(){
    console.log(this.tokenDetails.token)
    this.service.doAuthentication(this.tokenDetails).subscribe(
      (response:any)=>{
        console.log(response)
        // set the details 
        this.tokenIsValidated=response.tokenValidated
        this.userIsAuthenticated=response.authentication
        console.log(response.authentication)

        // if(this.tokenIsValidated){
        //   if(this.userIsAuthenticated){
        //     this.route.navigateByUrl("/dashboard")
        //   }else{
        //     this.route.navigateByUrl("/login")
        //   }
        // }else{
        //   this.route.navigateByUrl("/login")
        // }
      },
      (err)=>{
        console.log(err)
      }
    )
  }
  // end of checking authorization permission

  // some events fire on dashboard pages load
  // declare variables
  isByNotestComponent:Boolean=false;
  componets={
    isHomeComponent:false,
    isProfileComponent:false
  }


  // active isBynotesComponets
  lodeByNotestComponent(){
    this.isByNotestComponent=true;
  }


}
