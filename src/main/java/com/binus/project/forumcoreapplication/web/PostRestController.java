package com.binus.project.forumcoreapplication.web;

import com.binus.project.forumcoreapplication.domain.entities.Post;
import com.binus.project.forumcoreapplication.domain.models.CreatePost;
import com.binus.project.forumcoreapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/posts")
@CrossOrigin(origins = {"https://5ee67ef494e11be92b99cf62--blissful-mayer-5672f4.netlify.app","http://localhost:3000"})
public class PostRestController {


    @Autowired
    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    List<Post> getPostAll() {
        return postService.getPostAll();
    }

    @PostMapping
    String createPost(@RequestBody CreatePost createPost) {
        postService.createPost(createPost);
        return "post created";
    }


    @DeleteMapping("/{postId}")
    String deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return "post deleted";


    }

    @GetMapping("/{postId}")
    String likePost(@PathVariable Long postId) {
        postService.likePost(postId);
        return "post liked";
    }

    @GetMapping("/getPostById/{postId}")
    Post getPostById(@PathVariable Long postId) {
        return  postService.getPostById(postId);
    }
}
