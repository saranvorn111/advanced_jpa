package com.devkh.advancedjpa.assanbiler;

import com.devkh.advancedjpa.controller.ProductController;
import com.devkh.advancedjpa.dto.ProductDto;
import com.devkh.advancedjpa.entity.Product;
import com.devkh.advancedjpa.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, EntityModel<ProductDto>> {

    @Autowired
    private  ProductMapper productMapper;


    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @SuppressWarnings("unchecked")
    public ProductModelAssembler() {
        super(ProductController.class, (Class<EntityModel<ProductDto>>) (Class<?>)EntityModel.class);
    }

    @Override
    public CollectionModel<EntityModel<ProductDto>> toCollectionModel(Iterable<? extends Product> entities) {
        return super.toCollectionModel(entities);
    }

    @Override
    public EntityModel<ProductDto> toModel(Product entity) {
        ProductDto productDto = productMapper.mapProductToProductDto(entity);

        Link selfLink = linkTo(methodOn(ProductController.class).findProducts()).withSelfRel();

        Link collection = linkTo(methodOn(ProductController.class).findProductByUuid(entity.getUuid())).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(productDto,selfLink,collection);
    }
}
