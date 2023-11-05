package com.auth.authentication.AdminServices.NewsServices;

import com.auth.authentication.Entities.NewsFeedModel.NewsFeeds;
import java.util.*;
public interface NewsService {
    public NewsFeeds addNews(NewsFeeds postednews);
    public List<NewsFeeds> getNews();
}
