import { LocationStrategy } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-startquize',
  templateUrl: './startquize.component.html',
  styleUrls: ['./startquize.component.css']
})
export class StartquizeComponent implements OnInit{
  constructor(private activatedRouter:ActivatedRoute){}

  // declare the some variables
  quize_id:any;
  ngOnInit(){
    this.quize_id=this.activatedRouter.snapshot.params['quize_id'];

    
  
  }

  
}
