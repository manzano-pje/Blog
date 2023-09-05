package com.pjem.api.services;

import com.pjem.api.dtos.UserReturnDTO;
import com.pjem.api.dtos.UsersDTO;
import com.pjem.api.entities.Users;
import com.pjem.api.repositories.UsersRepository;
import com.pjem.api.services.exceptions.users.UserNotFoundException;
import com.pjem.api.services.exceptions.users.UserRegisteredException;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@AllArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper mapper;


    public UsersService(UsersRepository usersRepository, ModelMapper mapper) {
        this.usersRepository = usersRepository;
        this.mapper = mapper;
    }

    public UserReturnDTO create(UsersDTO usersDTO) {
        Optional<Users> usersOptional = usersRepository.findByEmail(usersDTO.getEmail());
        if (usersOptional.isPresent()) {
            throw new UserRegisteredException();
        }

        Users user = mapper.map(usersDTO, Users.class);
        user.setPassword(usersDTO.getPassword());
        usersRepository.save(user);
        return  new UserReturnDTO(
                user.getIdUser(),
                user.getName(),
                user.getEmail(),
                user.getProfilePicture(),
                user.getUserType());

    }

    public UserReturnDTO profile(Long id){
        Optional<Users> userOptional = usersRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException();
        }
        return  new UserReturnDTO(
                userOptional.get().getIdUser(),
                userOptional.get().getName(),
                userOptional.get().getEmail(),
                userOptional.get().getProfilePicture(),
                userOptional.get().getUserType());

    }

    public UserReturnDTO update_profile(Long id, UsersDTO usersDTO){
        Optional<Users> userOptional = usersRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException();

        }
        userOptional.get().setIdUser(userOptional.get().getIdUser());
        userOptional.get().setPassword(userOptional.get().getPassword());
        usersRepository.save(userOptional.get());

        return  new UserReturnDTO(
                userOptional.get().getIdUser(),
                userOptional.get().getName(),
                userOptional.get().getEmail(),
                userOptional.get().getProfilePicture(),
                userOptional.get().getUserType());
    }

    public ResponseEntity<Object> delete_profile(Long id){
        Optional<Users> userOptional = usersRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException();
        }
        usersRepository.deleteById(id);
        return null;
    }
}
