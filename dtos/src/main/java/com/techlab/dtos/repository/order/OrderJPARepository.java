package com.techlab.dtos.repository.order;

import com.techlab.dtos.models.entity.OrderMySQL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJPARepository extends JpaRepository<OrderMySQL, Long> {

}
