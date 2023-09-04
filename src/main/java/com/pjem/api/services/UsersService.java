package com.pjem.api.services;

import com.pjem.api.dtos.UserReturnDTO;
import com.pjem.api.dtos.UsersDTO;
import com.pjem.api.entities.Users;
import com.pjem.api.repositories.UsersRepository;
import com.pjem.api.services.exceptions.users.UserNotFoundExceptoin;
import com.pjem.api.services.exceptions.users.UserRegisteredException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@AllArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper mapper;


    public UsersService(UsersRepository usersRepository, ModelMapper mapper) {
        this.usersRepository = usersRepository;
        this.mapper = mapper;
    }

    public UserReturnDTO create(UsersDTO usersDTO){
        Optional<Users> usersOptional = usersRepository.findByEmail(usersDTO.getEmail());
        if(usersOptional.isPresent()) {
            throw new UserRegisteredException();
        }

        Users user = mapper.map(usersDTO, Users.class);
        usersRepository.save(user);
        UserReturnDTO retorno = new UserReturnDTO(
                user.getIdUser(),
                user.getName(),
                user.getEmail(),
                user.getProfilePicture(),
                user.getUserType());
        return retorno;
    }

    public List<UserReturnDTO> all_posts(){
        List<Users> usersList = usersRepository.findAll();
        if(usersList.isEmpty()){
            throw new UserNotFoundExceptoin();
        }
        return usersList.stream().map(UserReturnDTO::new).collect(Collectors.toList());
    }
}
