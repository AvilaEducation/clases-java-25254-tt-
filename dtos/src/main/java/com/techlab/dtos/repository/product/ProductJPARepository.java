package com.techlab.dtos.repository.product;


import com.techlab.dtos.models.entity.ProductMySQL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<ProductMySQL, Long> {

}
