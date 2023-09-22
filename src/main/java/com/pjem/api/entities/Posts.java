package com.pjem.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPost;

    private long idUser;
    private String title;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private long likes;
    private String coverImage;

    /****
     * RELATIONS
     */

    @ManyToOne
    @JoinColumn(name = "posts_Id", insertable=false, updatable=false)
    Users users;

    @OneToMany(mappedBy = "posts")
    List<Tags> listTags;

}
