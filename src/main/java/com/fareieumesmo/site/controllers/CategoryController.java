package com.fareieumesmo.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fareieumesmo.site.entities.Category;
import com.fareieumesmo.site.services.CategoryService;

@RestController
@CrossOrigin("*")
public class CategoryController {
    private final String admin = "/admin";
    private final String categories = "/categories";
    private final String create = "/create";
    private final String list = "/list";

    @Autowired
    CategoryService categoryService;

    @PostMapping(admin + categories + create)
    public ResponseEntity<String> postNewCode(@RequestBody Category category) {
        try {
            categoryService.saveNewCategory(category);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria criada com sucesso");
    }

    @GetMapping(admin + categories + list)
    public ResponseEntity<Iterable<Category>> getCodes() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAllCategories());
    }
}
