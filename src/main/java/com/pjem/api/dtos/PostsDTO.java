package com.pjem.api.dtos;

import com.pjem.api.entities.Posts;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostsDTO {

    private long idPost;
    private long idUser;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private long likes;
    private String coverImage;

    public PostsDTO(long idPost, long idUser, String title, String content, LocalDateTime createDate, LocalDateTime updateDate, long likes, String coverImage) {
        this.idPost = idPost;
        this.idUser = idUser;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.likes = likes;
        this.coverImage = coverImage;
    }

    public PostsDTO (Posts posts){
        idPost = posts.getIdPost();
        idUser = posts.getIdUser();
        title = posts.getTitle();
        content = posts.getContent();
        createDate = posts.getCreateDate();
        updateDate = posts.getUpdateDate();
        likes = posts.getLikes();
        coverImage = posts.getCoverImage();
    }

}
