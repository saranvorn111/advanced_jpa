package com.devkh.advancedjpa.init;

import com.devkh.advancedjpa.entity.Category;
import com.devkh.advancedjpa.entity.Price;
import com.devkh.advancedjpa.entity.Product;
import com.devkh.advancedjpa.repostitory.CategoryRepository;
import com.devkh.advancedjpa.repostitory.PriceRepository;
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
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    @PostConstruct
    public void init(){

        System.out.println("Hello everyone");
        //category

        Category electronic = Category.builder().name("electronic").build();
        Category smartphone =Category.builder().name("smartPhone").build();

        categoryRepository.saveAll(List.of(electronic,smartphone));

        //price

        Price defaultPrice = Price.builder()
                .princeIn(BigDecimal.valueOf(1000))
                .princeOut(BigDecimal.valueOf(1500))
                .build();

        Price spacialPrice = Price.builder()
                .princeIn(BigDecimal.valueOf(700))
                .princeOut(BigDecimal.valueOf(800))
                .build();

        priceRepository.saveAll(List.of(defaultPrice,spacialPrice));


        Product product1 = Product.builder()
                .uuid(UUID.randomUUID().toString())
                .name("samsung")
                .description("samsung 12")
                .category(electronic)
                .prices(List.of(defaultPrice,spacialPrice))
                .build();

        Product product2 = Product.builder()
                .uuid(UUID.randomUUID().toString())
                .name("Iphone 12pro")
                .description("Apple ")
                .category(smartphone)
                .prices(List.of(defaultPrice,spacialPrice))
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
