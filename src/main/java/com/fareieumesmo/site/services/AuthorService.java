package com.fareieumesmo.site.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fareieumesmo.site.entities.Author;
import com.fareieumesmo.site.repositories.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public void saveNewAuthor(Author author) {
        authorRepository.save(author);
    }

    public Optional<Author> findOneAuthor(Integer id) {
        return authorRepository.findById(id);
    }

    public Iterable<Author> findAllCategories() {
        return authorRepository.findAll();
    }
}