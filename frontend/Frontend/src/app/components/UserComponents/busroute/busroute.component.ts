import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-busroute',
  templateUrl: './busroute.component.html',
  styleUrls: ['./busroute.component.css']
})
export class BusrouteComponent implements OnInit{
  ngOnInit(){

    // call bus route animation
    this.busRouteAnimations();
  }


  busRouteAnimations(){
    // get all bus route box
    let busRouteBox=document.querySelectorAll(".bus-route")
    // check each bus route box that active or not
    busRouteBox.forEach(element => {
      element.addEventListener("click",()=>{
        busRouteBox.forEach(current=>{
          current.classList.remove("active-bus-route")
        })
        element.classList.add("active-bus-route")
      })
    });
  }

}
