package com.isteer.dcm.repository;

import com.isteer.dcm.entity.DistributorInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistributorInventoryRepository extends JpaRepository<DistributorInventory, Long> {
    // Update the parameter type to Long
    //DistributorInventory findByUpc(Long upc);

  //  @Query("SELECT d.stock_status FROM DistributorInventory d WHERE d.upc = :upc")
    Optional<DistributorInventory> findById(Long upc);
}
