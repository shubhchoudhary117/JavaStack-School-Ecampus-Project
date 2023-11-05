import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-sidebar',
  templateUrl: './admin-sidebar.component.html',
  styleUrls: ['./admin-sidebar.component.css']
})
export class AdminSidebarComponent implements OnInit{
  ngOnInit(){
    this.sidebarActiveLinkAnimation();
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
}
