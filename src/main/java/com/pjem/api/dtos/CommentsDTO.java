package com.pjem.api.dtos;

import com.pjem.api.entities.Comments;
import lombok.Data;

@Data
public class CommentsDTO {

    private long idComments;
    private long idUser;
    private long idPost;
    private String comment;

    public CommentsDTO(long idComments, long idUser, long idPost, String comment) {
        this.idComments = idComments;
        this.idUser = idUser;
        this.idPost = idPost;
        this.comment = comment;
    }

    public CommentsDTO(Comments comments) {
        idComments = comments.getIdComments();
        idUser = comments.getIdUser();
        idPost = comments.getIdPost();
        comment = comments.getComment();
    }
}
