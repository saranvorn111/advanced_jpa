package com.devkh.advancedjpa.service;

import com.devkh.advancedjpa.assanbiler.ProductModelAssembler;
import com.devkh.advancedjpa.entity.Product;
import com.devkh.advancedjpa.repostitory.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{


    private final ProductRepository productRepository;
    private final ProductModelAssembler productModelAssembler;

    @Override
    public CollectionModel<?> findProducts() {

        List<Product> products = productRepository.findAll();

        return productModelAssembler.toCollectionModel(products);
    }

    @Override
    public EntityModel<?> findProductByUuid(String uuid) {

        Product product = productRepository.findProductByUuid(uuid).orElseThrow();
        return productModelAssembler.toModel(product);
    }
}
