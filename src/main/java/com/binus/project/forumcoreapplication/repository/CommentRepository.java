package com.binus.project.forumcoreapplication.repository;

import com.binus.project.forumcoreapplication.domain.entities.Comment;
import com.binus.project.forumcoreapplication.domain.entities.Post;

import java.util.List;

public interface CommentRepository extends BaseRepository<Comment>  {

    List<Comment> findByPost(Post post);
}
