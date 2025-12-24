package com.techlab.dtos.models.dto;

import java.util.List;

public record OrderDTO(
    String name,
    List<OrderItemDTO> items
) {

}
