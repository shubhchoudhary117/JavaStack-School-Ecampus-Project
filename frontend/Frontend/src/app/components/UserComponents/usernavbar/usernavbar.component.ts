import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-usernavbar',
  templateUrl: './usernavbar.component.html',
  styleUrls: ['./usernavbar.component.css']
})
export class UsernavbarComponent implements OnInit{
  constructor(private tokenService:TokenService,private router:Router){}
  ngOnInit() {
  }

  // close profile popup
  profilePopup:any;
  profilePopIcon:any;
  showProfileWrapper:any;
  showProfileIcon:any;
  hideProfileIcon:any;
  closePopup(){
    this.profilePopup=document.getElementById("profile-popup")
    this.profilePopIcon=document.getElementById("profile-popup-icon")
    this.hideProfileIcon=document.getElementById("hide-profile-icon")
    this.showProfileIcon=document.getElementById("show-profile-icon")
    this.profilePopup.style.top="160%"; 
    this.profilePopup.style.display="none"
    this.hideProfileIcon.style.display="none"
    this.showProfileIcon.style.display="block"
  
  }

  // show profile popup
  showProfilePopup(){

    this.profilePopup=document.getElementById("profile-popup")
    this.profilePopIcon=document.getElementById("profile-popup-icon")
    this.hideProfileIcon=document.getElementById("hide-profile-icon")
    this.showProfileIcon=document.getElementById("show-profile-icon")
    this.profilePopup.style.display="block"
    this.profilePopup.style.top="110%";
    this.hideProfileIcon.style.display="block";
    this.showProfileIcon.style.display="none";
    
  }

  logoutUser(){
    // remove jwt token and logout the user
    this.tokenService.deleteToken();
    // and close the profile popup
    this.profilePopup=document.getElementById("profile-popup")
    this.profilePopIcon=document.getElementById("profile-popup-icon")
    this.hideProfileIcon=document.getElementById("hide-profile-icon")
    this.showProfileIcon=document.getElementById("show-profile-icon")
    this.profilePopup.style.top="160%"; 
    this.profilePopup.style.opacity="0"
    this.hideProfileIcon.style.display="none"
    this.showProfileIcon.style.display="block"
    
    // redirect the user on login page
    this.router.navigateByUrl("/revaecampus/login")

  }

}
