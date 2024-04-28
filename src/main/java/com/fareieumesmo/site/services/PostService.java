package com.fareieumesmo.site.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fareieumesmo.site.entities.Post;
import com.fareieumesmo.site.repositories.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void saveNewPost(Post post) {
        postRepository.save(post);
    }

    public Optional<Post> findOnePost(Integer id) {
        return postRepository.findById(id);
    }

    public Iterable<Post> findAllCategories() {
        return postRepository.findAll();
    }
}