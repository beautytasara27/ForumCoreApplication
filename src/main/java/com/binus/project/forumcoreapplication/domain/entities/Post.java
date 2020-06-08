package com.binus.project.forumcoreapplication.domain.entities;

import com.binus.project.forumcoreapplication.domain.models.CreatePost;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "post")
@TableGenerator(name = "post_id_generator",
        table = "id_generator",
        pkColumnName = "id_name",
        pkColumnValue = "post",
        valueColumnName = "id_value")
public class Post {


    @Id
    @GeneratedValue(generator = "post_id_generator")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "date_created")
    private Date dateCreated;
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "title", nullable = false, length = 500)
    private String title;
    @Column(name = "content", nullable = false, length = 2500)
    private String content;
    @Column(name = "likes")
    private Long likes;


    //default constructor for hibernate
    public Post() {
    }

    public Post(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }

    //singleton for creating post
    public static Post createPost(CreatePost createPost) {
       // returns a post object
        return  new Post(createPost.getUsername(),createPost.getTitle(),createPost.getContent());
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }
}
