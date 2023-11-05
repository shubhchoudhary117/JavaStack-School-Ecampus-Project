import { Component, OnInit } from '@angular/core';
import { AdminProfileService } from 'src/app/services/ProfileServices/adminprofile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private adminProfileService:AdminProfileService){}
  // declare the details storing array 
  adminDetails:any=[];
  // declare variavles
  start:any=0;
  deg:any=360;
  rank:any=50
  progressBar:any;
  ngOnInit() {
    // call the animation functin
    this.profileRankingAnimation();

    // call the backend api for get admin profile details
    this.adminProfileService.getAdminDetails().subscribe(
      (details:any)=>{
        console.log(details)
        // set admin details
        this.adminDetails=details;
      },(err:any)=>{
        console.log(err)
      }
    )
  }

  profileRankingAnimation(){
    this.progressBar=document.getElementById("progress-circular")

    let intervalObj= setInterval(()=>{
       this.start++;
       this.progressBar.style.background=`conic-gradient(#0D9fbf ${this.start}%,#ededed 0deg)`;
       if(this.start==this.rank){
         clearInterval(intervalObj)
       }
     })
  }

}
