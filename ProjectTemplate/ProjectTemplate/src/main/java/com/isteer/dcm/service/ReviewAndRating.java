package com.isteer.dcm.service;

import com.isteer.dcm.entity.Products;
import com.isteer.dcm.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ReviewAndRating {
    @Autowired
    private ProductsRepository productsRepository;

    @Transactional
    public Products getProductByStoreId(String storeId) {
        return productsRepository.findByStore_Id(BigDecimal.valueOf(Long.parseLong(storeId))).orElse(null);
    }
}
