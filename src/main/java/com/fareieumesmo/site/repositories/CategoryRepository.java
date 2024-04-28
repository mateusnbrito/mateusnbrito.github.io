package com.fareieumesmo.site.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fareieumesmo.site.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}