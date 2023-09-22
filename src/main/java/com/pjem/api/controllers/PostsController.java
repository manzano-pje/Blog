package com.pjem.api.controllers;

import com.pjem.api.dtos.PostsDTO;
import com.pjem.api.services.PostsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class PostsController {

    private final PostsService postsService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody PostsDTO postsDTO){
        PostsDTO retorno = postsService.create(postsDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(retorno.getIdPost()).toUri();
        return ResponseEntity.created(uri).body("Post registered.");
    }

    @GetMapping("/all_posts")
    public List<PostsDTO> listAll(){
        return postsService.listall();
    }

    @GetMapping("/{id}")
    public PostsDTO listOne(@PathVariable Long id){
        return postsService.listOne(id);
    }

    @DeleteMapping("/delete_post/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        postsService.delete(id);
        return ResponseEntity.ok().body("Post deleted.");
    }
}
