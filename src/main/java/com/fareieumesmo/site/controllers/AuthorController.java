package com.fareieumesmo.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fareieumesmo.site.entities.Author;
import com.fareieumesmo.site.services.AuthorService;

@RestController
@CrossOrigin("*")
public class AuthorController {
    private final String admin = "/admin";
    private final String authors = "/authors";
    private final String create = "/create";
    private final String list = "/list";

    @Autowired
    AuthorService authorService;

    @PostMapping(admin + authors + create)
    public ResponseEntity<String> postNewCode(@RequestBody Author author) {
        try {
            authorService.saveNewAuthor(author);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Autor criado com sucesso");
    }

    @GetMapping(admin + authors + list)
    public ResponseEntity<Iterable<Author>> getCodes() {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.findAllCategories());
    }
}
