package com.binus.project.forumcoreapplication.domain.entities;

import com.binus.project.forumcoreapplication.domain.models.CreateComment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "comment")
@TableGenerator(name = "comment_id_generator",
        table = "id_generator",
        pkColumnName = "id_name",
        pkColumnValue = "comment",
        valueColumnName = "id_value")
public class Comment {

    @Id
    @GeneratedValue(generator = "comment_id_generator")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "date_created")
    private Date dateCreated;
    @Column(name = "likes")
    private Long likes;
    @Column(name = "content", nullable = false, length = 2500)
    private String content;
    @ManyToOne
    @JsonIgnore
    private  Post post;


    //default constructor
    public Comment() {
    }

    public Comment(String username, String content, Post post) {
        this.username = username;
        this.content = content;
        this.post = post;
    }
    // singleton for creating comment object
    public static Comment createComment(CreateComment createComment , Post post) {
        return new Comment(createComment.getUsername(),createComment.getContent(),post);
    }
    // initialise  date and likes before persist
    @PrePersist
    public void onCreate() {
        dateCreated = new Date();
        this.setLikes(0L);

    }

    @PreUpdate
    public void onUpdate() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
