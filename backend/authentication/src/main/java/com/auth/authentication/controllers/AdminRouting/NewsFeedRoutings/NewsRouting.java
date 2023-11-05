package com.auth.authentication.controllers.AdminRouting.NewsFeedRoutings;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authentication.AdminServices.NewsServices.NewsServiceImpl;
import com.auth.authentication.Entities.AdminModel.TeachersModel.TeachersDetailsSchema;
import com.auth.authentication.Entities.NewsFeedModel.NewsFeeds;
import com.auth.authentication.Headers.NewsHeaders.AddNewsHeader;
import com.auth.authentication.Response.AdminNewsFeedResponses.AddNewsResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/news")
public class NewsRouting {
    
    @Autowired
    NewsServiceImpl newsService;

    @Autowired
    AddNewsResponse addNewsResponse;

    @GetMapping("/testnews")
    public String TestNews(){
        return "news is tested";
    }

    // post the new news
    @PostMapping("/addnews")
    public ResponseEntity<?> PostNews(@RequestBody AddNewsHeader newsHeader){
        // define the date object
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter myPatternDateTime=DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");    
        String formattedDate =date.format(myPatternDateTime);
       //set the teachers details 
        TeachersDetailsSchema teacher=new TeachersDetailsSchema();
        teacher.setTid(1);

        // create the newsfeed object
        NewsFeeds newsFeeds=new NewsFeeds();
        newsFeeds.setNewscontent(newsHeader.getContent());
        newsFeeds.setNewsdate(formattedDate);
        Set<NewsFeeds> newsSet=new LinkedHashSet<>();
        newsSet.add(newsFeeds);
        teacher.setNewses(newsSet);
        newsFeeds.setTeacher(teacher);
        // insert the news in database
        NewsFeeds addedNews=this.newsService.addNews(newsFeeds);
        
        // set the response object
        if(addedNews!=null){
            this.addNewsResponse.setInvalidToken(false);
            this.addNewsResponse.setNewsIsAdded(true);
            this.addNewsResponse.setSomethingWentWrong(false);
        }else{
            this.addNewsResponse.setInvalidToken(false);
            this.addNewsResponse.setNewsIsAdded(false);
            this.addNewsResponse.setSomethingWentWrong(true);
        }
        return ResponseEntity.ok(this.addNewsResponse);

    }

    // get all news
   @GetMapping("/getnews")
   public ResponseEntity<?> GetAllNews(){
    List<NewsFeeds> allNews=this.newsService.getNews();
    return ResponseEntity.ok(allNews);
   }
    
}
