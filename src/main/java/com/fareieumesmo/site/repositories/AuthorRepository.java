package com.fareieumesmo.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fareieumesmo.site.entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
}