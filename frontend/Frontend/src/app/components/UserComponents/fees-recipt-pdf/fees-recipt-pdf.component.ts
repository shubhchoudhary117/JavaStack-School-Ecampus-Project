import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';
@Component({
  selector: 'app-fees-recipt-pdf',
  templateUrl: './fees-recipt-pdf.component.html',
  styleUrls: ['./fees-recipt-pdf.component.css']
})


export class FeesReciptPdfComponent implements OnInit {

  constructor(private acitvatedRoute: ActivatedRoute,private router:Router) {  }

  feesReciptTemplate: any;
  bodyHtml:any;
  ngOnInit() {
    let reciptId = this.acitvatedRoute.snapshot.params["reciptid"];
    //  call the printer function
    setTimeout(() => {
      this.DownloadFeesReciptPDF();
    }, 2000);
  }


  DownloadFeesReciptPDF() {
    window.print();
    setTimeout(()=>{
      window.close();
      this.router.navigate(["/student/dashboard"])
    },3000)
  }




}
