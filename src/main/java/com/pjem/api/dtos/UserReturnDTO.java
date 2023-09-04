package com.pjem.api.dtos;

import com.pjem.api.entities.Users;
import lombok.Data;

@Data
public class UserReturnDTO {
    private Long idUser;
    private String name;
    private String email;
    private String profilePicture;
    private String userType;

    public UserReturnDTO(Long idUser,
                         String name,
                         String email,
                         String profilePicture,
                         String userType) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.profilePicture = profilePicture;
        this.userType = userType;
    }

    public UserReturnDTO(Users users){
        idUser = users.getIdUser();
        name = users.getName();
        email = users.getEmail();
        profilePicture = users.getProfilePicture();
        userType = users.getUserType();
    }
}
