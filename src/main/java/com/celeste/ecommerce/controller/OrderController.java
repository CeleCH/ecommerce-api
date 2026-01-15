package com.celeste.ecommerce.controller;

import com.celeste.ecommerce.model.*;
import com.celeste.ecommerce.repository.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepo;
    private final OrderItemRepository orderItemRepo;
    private final CartItemRepository cartRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public OrderController(OrderRepository orderRepo, OrderItemRepository orderItemRepo,
                           CartItemRepository cartRepo, UserRepository userRepo,
                           ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
        this.cartRepo = cartRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
    }

    @PostMapping("/checkout/{userId}")
    public Order checkout(@PathVariable Long userId) {
        User user = userRepo.findById(userId).get();
        List<CartItem> cart = cartRepo.findByUser(user);

        double total = 0;

        for (CartItem item : cart) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }

        Order order = new Order();
        order.setUser(user);
        order.setDate(LocalDateTime.now());
        order.setTotal(total);
        orderRepo.save(order);

        for (CartItem item : cart) {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setProduct(item.getProduct());
            oi.setQuantity(item.getQuantity());
            orderItemRepo.save(oi);

            Product p = item.getProduct();
            p.setStock(p.getStock() - item.getQuantity());
            productRepo.save(p);
        }

        cartRepo.deleteAll(cart);

        return order;
    }
}
