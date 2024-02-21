package com.isteer.dcm.repository;

import com.isteer.dcm.compositekeys.ProductCompositeKey;
import com.isteer.dcm.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ProductsRepository extends JpaRepository<Products, ProductCompositeKey> {

    @Query(value = "SELECT * FROM Products WHERE upc = :upc", nativeQuery = true)

  Optional<Products> fetchByUpc(@RequestParam("UPC") BigDecimal upc);
    //Optional<Products>findByStore_Id(BigDecimal store_Id);
    Optional<Products>findBySellerId(Integer sellerId);

}
