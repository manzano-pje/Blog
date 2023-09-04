package com.pjem.api.controllers;

import com.pjem.api.dtos.UserReturnDTO;
import com.pjem.api.dtos.UsersDTO;
import com.pjem.api.services.UsersService;
import jakarta.servlet.Servlet;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/signup")
    public ResponseEntity<Object> create(@RequestBody UsersDTO usersDTO){
        UserReturnDTO userReturn = usersService.create(usersDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
                buildAndExpand(userReturn.getIdUser()).toUri();
        return ResponseEntity.created(uri).body("User created.");
    }

    @GetMapping("/all_posts")
    public List<UserReturnDTO> all_posts(){

        return usersService.all_posts();
    }
}
