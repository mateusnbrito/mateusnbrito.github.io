package com.fareieumesmo.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fareieumesmo.site.entities.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
}