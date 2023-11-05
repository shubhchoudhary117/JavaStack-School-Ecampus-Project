package com.auth.authentication.Repositery.AdminRepository.NewsRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authentication.Entities.NewsFeedModel.NewsFeeds;

public interface NewsRepo extends JpaRepository<NewsFeeds,Integer> {
    
}
