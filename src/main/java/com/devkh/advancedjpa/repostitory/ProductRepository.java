package com.devkh.advancedjpa.repostitory;

import com.devkh.advancedjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//Entity and primary in JpaRepository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT pro.name,pro.description,pro.price FROM Product AS pro")
    Optional<Product> findByUuid(String uuid);
}
