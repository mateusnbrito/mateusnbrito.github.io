package com.fareieumesmo.site.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fareieumesmo.site.entities.Category;
import com.fareieumesmo.site.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void saveNewCategory(Category category) {
        categoryRepository.save(category);
    }

    public Optional<Category> findOneCategory(Integer id) {
        return categoryRepository.findById(id);
    }

    public Iterable<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
}