package com.devkh.advancedjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="products")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true,nullable = false)

    private String uuid;
    @Column(name = "pro-name",length = 100,nullable = false)
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

    @ManyToMany
    @JoinTable (name = "product_price",
            joinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "price_id",referencedColumnName = "id"))
    private List<Price> prices;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
}
