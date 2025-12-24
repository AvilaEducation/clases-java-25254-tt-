package com.techlab.dtos.models.dto.response;

public record OrderResponseDTO(
    Long id,
    String name,
    Double totalPrice
) {

}
