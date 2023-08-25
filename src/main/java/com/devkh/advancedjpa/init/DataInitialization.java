package com.devkh.advancedjpa.init;

import com.devkh.advancedjpa.entity.Product;
import com.devkh.advancedjpa.repostitory.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitialization {

    private final ProductRepository productRepository;
    @PostConstruct
    public void init(){

        System.out.println("Hello everyone");

        Product product1 = Product.builder()
                .uuid(UUID.randomUUID().toString())
                .name("samsung")
                .description("samsung 12")
                .price(BigDecimal.valueOf(200))
                .build();

        Product product2 = Product.builder()
                .uuid(UUID.randomUUID().toString())
                .name("Iphone 12pro")
                .description("Apple ")
                .price(BigDecimal.valueOf(1300))
                .build();
        productRepository.saveAll(List.of(product1,product2));

//        productRepository.save(product1);
//        productRepository.save(product2);

        System.out.println(product1.getId());
        System.out.println(product2.getId());

        List<Product> productList = productRepository.findAll();
        productList.forEach(product -> System.out.println(product.getName()));

    }
}
