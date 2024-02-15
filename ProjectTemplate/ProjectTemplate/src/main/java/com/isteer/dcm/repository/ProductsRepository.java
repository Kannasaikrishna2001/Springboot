package com.isteer.dcm.repository;

import com.isteer.dcm.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ProductsRepository extends JpaRepository<Products, Long> {

    Optional<Products> findById(String productId);
}
