package com.isteer.dcm.repository;

import com.isteer.dcm.compositekeys.ProductCompositeKey;
import com.isteer.dcm.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ProductsRepository extends JpaRepository<Products, ProductCompositeKey> {
    Optional<Products> findById(ProductCompositeKey productId);
    //Optional<Products>findByStore_Id(BigDecimal store_Id);
    Optional<Products>findBySellerId(Integer sellerId);

}
