package com.auth.authentication.AdminServices.NewsServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authentication.Entities.NewsFeedModel.NewsFeeds;
import com.auth.authentication.Repositery.AdminRepository.NewsRepositories.NewsRepo;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    NewsRepo newsRepo;

    @Override
    public NewsFeeds addNews(NewsFeeds postednews) {
        // insert the news content in database
       NewsFeeds addedNews= this.newsRepo.save(postednews);
        return addedNews;
    }

    @Override
    public List<NewsFeeds> getNews() {
      List<NewsFeeds> allNews=this.newsRepo.findAll();
      return allNews;
    }
    
}
