import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/services/token.service';
declare var show: any;
@Component({
  selector: 'app-usersidebar',
  templateUrl: './usersidebar.component.html',
  styleUrls: ['./usersidebar.component.css']
})
export class UsersidebarComponent implements OnInit {
  ngOnInit() {

    show();
    this.sidebarActiveLinkAnimation();
  }

  constructor(private tokenService: TokenService) {

  }

  // create animation sidebar code
  sidebarActiveLinkAnimation() {
    let menus=document.querySelectorAll(".link-li")
    // algorithem
    menus.forEach((currentMenu)=>{
      currentMenu.addEventListener("click",()=>{
        menus.forEach((menu)=>{
          menu.classList.remove("active-menu")
          menu.classList.remove("active-icon")
        })
        currentMenu.classList.add("active-menu")
        currentMenu.classList.add("active-icon")
      })
    })
  }

  // logout the studet
  logoutStudent() {
    this.tokenService.deleteToken();
    window.location.href = "http://localhost:4200/student/dashboard/bus-route"
  }




  // get all link li


}
