package com.celeste.ecommerce.controller;

import com.celeste.ecommerce.model.Product;
import com.celeste.ecommerce.repository.ProductRepository;
import com.celeste.ecommerce.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository repo;
    private final CategoryRepository categoryRepo;

    public ProductController(ProductRepository repo, CategoryRepository categoryRepo) {
        this.repo = repo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product p) {
        var category = categoryRepo.findById(p.getCategory().getId()).get();
        p.setCategory(category);
        return repo.save(p);
    }
}
