package com.binus.project.forumcoreapplication.service;

import com.binus.project.forumcoreapplication.domain.entities.Article;
import com.binus.project.forumcoreapplication.domain.entities.Comment;
import com.binus.project.forumcoreapplication.domain.models.CreateArticleRequest;
import com.binus.project.forumcoreapplication.domain.models.CreateComment;

import java.util.List;

//interface for the comment service
public interface CommentService {

    List<Comment> getCommentAll(Long postId);

    Comment createComment(CreateComment createComment);

    void deleteComment(Long commentId);

    void likeComment(Long commentId);
}
