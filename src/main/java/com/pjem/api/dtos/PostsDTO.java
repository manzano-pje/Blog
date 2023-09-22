package com.pjem.api.dtos;

import com.pjem.api.entities.Posts;
import com.pjem.api.entities.Tags;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsDTO {

    private long idPost;
    private long idUser;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private long likes;
    private String coverImage;

    public PostsDTO(Posts posts) {
        this.idPost = posts.getIdPost();
        this.idUser = posts.getIdUser();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.createDate = posts.getCreateDate();
        this.updateDate = posts.getUpdateDate();
        this.likes = posts.getLikes();
        this.coverImage = posts.getCoverImage();
    }


}
