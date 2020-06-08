package com.binus.project.forumcoreapplication.service;

import com.binus.project.forumcoreapplication.domain.entities.Comment;
import com.binus.project.forumcoreapplication.domain.entities.Post;
import com.binus.project.forumcoreapplication.domain.models.CreatePost;
import com.binus.project.forumcoreapplication.repository.PostRepository;
import com.binus.project.forumcoreapplication.service.exceptions.InvalidRequestException;
import com.binus.project.forumcoreapplication.service.exceptions.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements  PostService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);

    private  final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getPostAll() {
        LOGGER.info("Get all posts service implement ");
        return postRepository.findAll();
    }

    @Override
    public Post getPost(Long postId) {
        LOGGER.info("Get  post service implement ");
        return postRepository.findById(postId).orElseThrow(() -> new InvalidRequestException("post not found"));

    }

    @Override
    public Post createPost(CreatePost createPost) {
        LOGGER.info("create post service implement ");
        Post post = Post.createPost(createPost);
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        LOGGER.info("delete post service implement ");
        postRepository.findById(postId).orElseThrow(() -> new RecordNotFoundException("post not found"));;
        postRepository.deleteById(postId);

    }

    @Override
    public void likePost(Long postId) {
        LOGGER.info("like post service implement ");
        Post post = postRepository.findById(postId).orElseThrow(() -> new InvalidRequestException("post not found"));
        Long likes = post.getLikes();
        post.setLikes(likes + 1);
        postRepository.save(post);

    }
    @Override
    public Post getPostById(Long postId){
        LOGGER.info("get post by id service implement");
        return postRepository.findById(postId).orElseThrow(() -> new InvalidRequestException("post not found"));
    }
}
