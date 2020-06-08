package com.binus.project.forumcoreapplication.web;

import com.binus.project.forumcoreapplication.domain.entities.Comment;
import com.binus.project.forumcoreapplication.domain.models.CreateComment;
import com.binus.project.forumcoreapplication.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/comments")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentRestController {


    @Autowired
    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{postId}")
    List<Comment> getCommentAll(@PathVariable  Long postId) {
        return commentService.getCommentAll(postId);
    }

    @PostMapping
    String createComment(@RequestBody CreateComment createComment) {
        commentService.createComment(createComment);
        return "comment created";
    }

    @DeleteMapping("/{commentId}")
    String deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return "comment deleted";

    }

    @GetMapping("/like/{commentId}")
    String likeComment(@PathVariable Long commentId) {
        commentService.likeComment(commentId);
        return "comment liked";
    }
}
