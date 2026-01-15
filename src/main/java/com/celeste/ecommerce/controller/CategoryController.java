package com.celeste.ecommerce.controller;

import com.celeste.ecommerce.model.Category;
import com.celeste.ecommerce.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository repo;

    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Category> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Category create(@RequestBody Category c) {
        return repo.save(c);
    }
}
