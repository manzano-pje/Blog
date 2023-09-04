package com.pjem.api.dtos;

import com.pjem.api.entities.Users;
import lombok.Data;

@Data
public class UsersDTO {

    private long idUser;
    private String name;
    private String email;
    private String password;
    private String profilePicture;
    private String userType;



    public UsersDTO(long idUser,
                    String name,
                    String email,
                    String password,
                    String profilePicture,
                    String userType) {

        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePicture = profilePicture;
        this.userType = userType;
    }

     public UsersDTO(Users users){
            idUser = users.getIdUser();
            name = users.getName();
            email = users.getEmail();
            password = users.getPassword();
            profilePicture = users.getProfilePicture();
            userType = users.getUserType();
     }
}
