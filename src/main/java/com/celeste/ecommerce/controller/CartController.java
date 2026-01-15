package com.celeste.ecommerce.controller;

import com.celeste.ecommerce.model.CartItem;
import com.celeste.ecommerce.model.User;
import com.celeste.ecommerce.repository.CartItemRepository;
import com.celeste.ecommerce.repository.ProductRepository;
import com.celeste.ecommerce.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartItemRepository cartRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public CartController(CartItemRepository cartRepo, UserRepository userRepo, ProductRepository productRepo) {
        this.cartRepo = cartRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
    }

    @PostMapping("/add")
    public CartItem add(@RequestBody AddCartRequest req) {
        User user = userRepo.findById(req.userId()).get();
        var product = productRepo.findById(req.productId()).get();

        CartItem item = new CartItem();
        item.setUser(user);
        item.setProduct(product);
        item.setQuantity(req.quantity());

        return cartRepo.save(item);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        User user = userRepo.findById(userId).get();
        return cartRepo.findByUser(user);
    }
}

record AddCartRequest(Long userId, Long productId, int quantity) {}
