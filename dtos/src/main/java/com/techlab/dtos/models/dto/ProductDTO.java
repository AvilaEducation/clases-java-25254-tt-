package com.techlab.dtos.models.dto;

public record ProductDTO(
    String name,
    String description,
    Double price,
    Integer stock
) {

}
