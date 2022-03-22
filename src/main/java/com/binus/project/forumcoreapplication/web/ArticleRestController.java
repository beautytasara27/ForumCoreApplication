package com.binus.project.forumcoreapplication.web;

import com.binus.project.forumcoreapplication.domain.entities.Article;
import com.binus.project.forumcoreapplication.domain.models.CreateArticleRequest;
import com.binus.project.forumcoreapplication.service.ArticleService;
import com.binus.project.forumcoreapplication.web.utils.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("v1/articles")
@CrossOrigin(origins = {"https://mentalhealthfirst.netlify.app","http://localhost:3000"})
class ArticleRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);
    @Autowired
    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping
    List<Article> getAllArticle() {
        LOGGER.info("Get all articles");
        return articleService.getAllArticle();
    }


    @PostMapping
    MessageResponse createArticle(@RequestBody CreateArticleRequest createArticleRequest) {
        System.out.println(createArticleRequest);
        LOGGER.info("Posting article : createArticleRequest={}", createArticleRequest);
        articleService.createArticle(createArticleRequest);
        return MessageResponse.createMessageResponse("article posted");
    }


    @DeleteMapping("/{articleId}")
    MessageResponse deleteArticle(@PathVariable Long articleId) {
        LOGGER.info("Deleting article");
        articleService.deleteArticle(articleId);
        return MessageResponse.createMessageResponse("article deleted");

    }


    @GetMapping("/{articleId}")
    MessageResponse likeArticle(@PathVariable Long articleId) {
        LOGGER.info("Like article");
        articleService.likeArticle(articleId);
        return MessageResponse.createMessageResponse("article liked");
    }
    @GetMapping("getById/{articleId}")
    Article getArticleById(@PathVariable Long articleId){
        LOGGER.info("get article by Id");
        return articleService.getArticleById(articleId);
    }

}
