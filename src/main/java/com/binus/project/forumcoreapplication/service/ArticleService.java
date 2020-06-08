package com.binus.project.forumcoreapplication.service;

import com.binus.project.forumcoreapplication.domain.entities.Article;
import com.binus.project.forumcoreapplication.domain.models.CreateArticleRequest;
import org.springframework.stereotype.Service;

import java.util.List;
//interface for the article service
@Service
public interface ArticleService {

    List<Article> getAllArticle();
    Article createArticle(CreateArticleRequest createArticleRequest);
    void    deleteArticle (Long articleId );
    void    likeArticle(Long articleId );
    Article    getArticleById(Long articleId);
}
