import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtauthenticationService } from 'src/app/services/jwtauthentication.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit{
  constructor(private tokenService:TokenService,private authService:JwtauthenticationService,private router:Router){
    
  }
  // authenticate the user
 
  ngOnInit(){
    
    this.checkAuthorizationPermissions();
    // navigate the news feed
  }

  // declare the check authorization permissions
   // set token details variables
   tokenIsValidated:Boolean=false;
   userIsAuthenticated:Boolean=false;
 
    // create jwt token details object
 tokenDetails={
  token:this.tokenService.getToken()
}
  checkAuthorizationPermissions(){
    // call the api
    this.authService.doAuthentication(this.tokenDetails).subscribe(
      (response:any)=>{
        console.log(response)
        // set the details 
        this.tokenIsValidated=response.tokenValidated
        this.userIsAuthenticated=response.authentication
      //  check authorization permissions
        if(this.tokenIsValidated){
          if(this.userIsAuthenticated){
            this.router.navigateByUrl("student/dashboard/news-feed")
          }else{
            this.router.navigateByUrl("revaecampus/login")
          }
        }else{
          this.router.navigateByUrl("revaecampus/login")
        }

      },
      (err:any)=>{
        console.log(err);
      })

}
}