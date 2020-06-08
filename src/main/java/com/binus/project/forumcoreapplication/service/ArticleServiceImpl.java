package com.binus.project.forumcoreapplication.service;

import com.binus.project.forumcoreapplication.domain.entities.Article;
import com.binus.project.forumcoreapplication.domain.models.CreateArticleRequest;
import com.binus.project.forumcoreapplication.repository.ArticleRepository;
import com.binus.project.forumcoreapplication.service.exceptions.InvalidRequestException;
import com.binus.project.forumcoreapplication.service.exceptions.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {
    private final static Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticle() {
        LOGGER.info("Get all article service implement ");
        return articleRepository.findAll();
    }

    @Override
    public Article createArticle(CreateArticleRequest createArticleRequest) {
        LOGGER.info("create article service implement ");
        Article article = Article.createArticle(createArticleRequest);
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long articleId) {
        LOGGER.info("delete article service implement ");
        articleRepository.findById(articleId).orElseThrow(() -> new RecordNotFoundException("Article not found"));;
        articleRepository.deleteById(articleId);
    }

    @Override
    public void likeArticle(Long articleId) {
        LOGGER.info("like article service implement ");
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new InvalidRequestException("Article not found"));
        Long likes = article.getLikes();
        article.setLikes(likes + 1);
        System.out.println(article.getLikes());
        articleRepository.save(article);


    }

    @Override
    public Article getArticleById(Long articleId){
        LOGGER.info("Get article by id service implement ");
        return articleRepository.findById(articleId).orElseThrow(() -> new InvalidRequestException("Article not found"));

    }
}
