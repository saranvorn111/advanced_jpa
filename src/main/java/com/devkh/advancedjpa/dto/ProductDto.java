package com.devkh.advancedjpa.dto;

import lombok.Builder;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Relation(collectionRelation = "products",itemRelation = "product")
public record ProductDto(String uuid,
                         String name,
                         String description) {
}
