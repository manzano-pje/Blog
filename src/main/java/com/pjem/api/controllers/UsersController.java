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
        UserReturnDTO userReturnDto = usersService.create(usersDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
                buildAndExpand(userReturnDto.getIdUser()).toUri();
        return ResponseEntity.created(uri).body("User created.");
    }

    @GetMapping("/profile/{id}")
    public UserReturnDTO profile(@PathVariable Long id){
        return usersService.profile(id);
    }

    @PatchMapping("/update_profile/{id}")
    public ResponseEntity<Object>  update_profile(@PathVariable long id, @RequestBody UsersDTO usersDTO){
        UserReturnDTO userReturnDto =  usersService.update_profile(id, usersDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
                buildAndExpand(userReturnDto.getIdUser()).toUri();
        return ResponseEntity.ok("User Updated.");
    }

    @DeleteMapping("profile/{id}")
    public ResponseEntity<Object> delete_profile(@PathVariable Long id){
        usersService.delete_profile(id);
        return ResponseEntity.ok("User deleted.");
    }
}
