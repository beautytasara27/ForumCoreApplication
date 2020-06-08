package com.binus.project.forumcoreapplication.service;

import com.binus.project.forumcoreapplication.domain.entities.Comment;
import com.binus.project.forumcoreapplication.domain.entities.Post;
import com.binus.project.forumcoreapplication.domain.models.CreateComment;
import com.binus.project.forumcoreapplication.domain.models.CreatePost;

import java.util.List;

//interface for the post service
public interface PostService {


    List<Post> getPostAll();

    Post getPost(Long postId);

    Post createPost(CreatePost createPost);

    void deletePost(Long postId);

    void likePost(Long postId);

    Post getPostById(Long postId);
}
