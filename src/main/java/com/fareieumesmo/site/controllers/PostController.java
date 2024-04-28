package com.fareieumesmo.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fareieumesmo.site.entities.Post;
import com.fareieumesmo.site.services.PostService;

@RestController
@CrossOrigin("*")
public class PostController {
    private final String admin = "/admin";
    private final String posts = "/posts";
    private final String create = "/create";
    private final String list = "/list";

    @Autowired
    PostService postService;

    @PostMapping(admin + posts + create)
    public ResponseEntity<String> postNewCode(@RequestBody Post post) {
        try {
            postService.saveNewPost(post);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Post criado com sucesso");
    }

    @GetMapping(admin + posts + list)
    public ResponseEntity<Iterable<Post>> getCodes() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.findAllCategories());
    }
}
