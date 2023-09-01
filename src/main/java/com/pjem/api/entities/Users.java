package com.pjem.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;

    private String name;
    private String email;
    private String password;
    private String profilePicture;
    private String userType;

    /****
     * RELATIONS
     */

    @OneToMany(mappedBy = "users")
    List<Posts> listPost;

    @OneToMany(mappedBy = "users")
    List<Comments> listComments;
}
