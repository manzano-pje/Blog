package com.pjem.api.services;

import com.pjem.api.dtos.PostsDTO;
import com.pjem.api.entities.Posts;
import com.pjem.api.repositories.PostsRepository;
import com.pjem.api.services.exceptions.posts.PostNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class PostsService {

    private final PostsRepository postsRepository;
    private final ModelMapper mapper;

    public PostsDTO create(PostsDTO postsDTO){
        Posts posts = mapper.map(postsDTO, Posts.class);
        posts.setCreateDate(LocalDateTime.now());
        posts.setLikes(0);
        return mapper.map(postsRepository.save(posts), PostsDTO.class);
    }

    public List<PostsDTO> listall(){
        List<Posts> postsList = postsRepository.findAll();
        if (postsList.isEmpty()){
            throw new PostNotFoundException();
        }
        List<PostsDTO> posts = postsList.stream().map(PostsDTO::new).collect(Collectors.toList());
        return posts;
    }

    public PostsDTO listOne(Long id){
        Optional<Posts> postsOptional = postsRepository.findById(id);
        if (postsOptional.isEmpty()){
            throw new PostNotFoundException();
        }

        return new PostsDTO(
            postsOptional.get().getIdPost(),
            postsOptional.get().getIdUser(),
            postsOptional.get().getTitle(),
            postsOptional.get().getContent(),
            postsOptional.get().getCreateDate(),
            postsOptional.get().getUpdateDate(),
            postsOptional.get().getLikes(),
            postsOptional.get().getCoverImage()
        );
    }

    public void delete(Long id){
        Optional<Posts> postsOptional = postsRepository.findById(id);
        if (postsOptional.isEmpty()){
            throw new PostNotFoundException();
        }
        postsRepository.deleteById(id);
        return;
    }


}
