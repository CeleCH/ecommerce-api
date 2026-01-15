package com.celeste.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    private String description;

    private double price;

    private int stock;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
