package com.isteer.dcm.repository;

import com.isteer.dcm.entity.DistributorInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorInventoryRepository extends JpaRepository<DistributorInventory, Long> {
    // Update the parameter type to Long
    //DistributorInventory findByUpc(Long upc);

    @Query("SELECT d.stock_status FROM DistributorInventory d WHERE d.upc = :upc")
    String findStockStatusByUpc(@Param("upc") Long upc);
}
