package com.celeste.ecommerce.repository;

import com.celeste.ecommerce.model.CartItem;
import com.celeste.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
}
