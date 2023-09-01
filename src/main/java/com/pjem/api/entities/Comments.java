package com.pjem.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComments;

    private long idUser;
    private long idPost;
    private String comment;

    /****
     * RELATIONS
     */

    @ManyToOne
    @JoinColumn(name = "comments_id", insertable = false, updatable = false)
    Posts posts;

    @ManyToOne
    @JoinColumn(name = "users_id", insertable = false, updatable = false)
    Users users;

}
