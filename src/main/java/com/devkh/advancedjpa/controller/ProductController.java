package com.devkh.advancedjpa.controller;

import com.devkh.advancedjpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.Collection;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public CollectionModel<?> findProducts(){

        return productService.findProducts();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findProductByUuid(@PathVariable String uuid){

        return productService.findProductByUuid(uuid);
    }
}
