package com.binus.project.forumcoreapplication.service;

import com.binus.project.forumcoreapplication.domain.entities.Article;
import com.binus.project.forumcoreapplication.domain.entities.Comment;
import com.binus.project.forumcoreapplication.domain.entities.Post;
import com.binus.project.forumcoreapplication.domain.models.CreateComment;
import com.binus.project.forumcoreapplication.repository.CommentRepository;
import com.binus.project.forumcoreapplication.service.exceptions.InvalidRequestException;
import com.binus.project.forumcoreapplication.service.exceptions.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl  implements  CommentService{
    private final static Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);
    private  final PostService postService;
    private  final CommentRepository commentRepository;

    public CommentServiceImpl(PostService postService, CommentRepository commentRepository) {
        this.postService = postService;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getCommentAll( Long postId) {
        LOGGER.info("Get all comments service implement ");
        Post post = postService.getPost(postId);
        return commentRepository.findByPost(post);
    }

    @Override
    public Comment createComment(CreateComment createComment) {
        LOGGER.info("create comment service implement ");
        Post post = postService.getPost(createComment.getPostId());
        Comment comment = Comment.createComment(createComment , post);
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        LOGGER.info("delete comment service implement ");
        commentRepository.findById(commentId).orElseThrow(() -> new RecordNotFoundException("comment not found"));;
        commentRepository.deleteById(commentId);

    }

    @Override
    public void likeComment(Long commentId) {
        LOGGER.info("like comment service implement ");
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new InvalidRequestException("comment not found"));
        Long likes = comment.getLikes();
        comment.setLikes(likes + 1);
        commentRepository.save(comment);
    }
}
