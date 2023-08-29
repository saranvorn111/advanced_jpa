package com.devkh.advancedjpa.service;

import lombok.Setter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;


public interface ProductService {

    CollectionModel<?> findProducts();

    EntityModel<?> findProductByUuid(String uuid);
}
