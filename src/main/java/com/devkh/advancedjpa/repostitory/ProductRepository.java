package com.devkh.advancedjpa.repostitory;

import com.devkh.advancedjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//Entity and primary in JpaRepository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findProductByUuid(String uuid);
}
