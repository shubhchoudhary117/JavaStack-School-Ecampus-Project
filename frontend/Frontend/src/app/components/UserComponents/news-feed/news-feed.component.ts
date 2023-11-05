import { Component, OnInit } from '@angular/core';

import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { NgxSpinnerService } from 'ngx-spinner';

import { PostnewsserviceService } from 'src/app/services/newsServices/postnewsservice.service';

@Component({
  selector: 'app-news-feed',
  templateUrl: './news-feed.component.html',
  styleUrls: ['./news-feed.component.css']
})
export class NewsFeedComponent implements OnInit {
  constructor(private newsService: PostnewsserviceService,
     private sanitizer: DomSanitizer,
     private spinner: NgxSpinnerService) { }

  spinnerType: any;
  spinnerName: any;
  activeLoader:boolean=false;
  ngOnInit() {

    // call the NewsFeed function for get all news from backend api and show this news in news feed component
    

    this.spinnerName = "sp1";
    this.spinnerType = "ball-atom";
    this.spinner.show(this.spinnerName);
    this.activeLoader=true;

    setTimeout(() => {
      this.activeLoader=false;
      this.spinner.hide(this.spinnerName);
    }, 5000)

    this.NewsFeeds();
  }




  // define thd array for containing the all news
  allNews: any = []

  // convert added text news to html
  newsContent: any;
  noAnyNews:boolean=false;
  // get all news and show news fedds
  NewsFeeds() {

    // call the api
    this.newsService.getNewsApi().subscribe(
      (response: any) => {
        // set the allnews arrya
        this.allNews = response;
        console.log(response);
        // if no any news is present than display the empty news message
        if(this.allNews.length==0){
         this.noAnyNews=true;
        }
      },
      (error: any) => {
        console.log(error)
      })
  }
}
// joddit text editor search in google
