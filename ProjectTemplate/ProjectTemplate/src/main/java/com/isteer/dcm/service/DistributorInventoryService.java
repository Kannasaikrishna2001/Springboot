package com.isteer.dcm.service;

import com.isteer.dcm.repository.DistributorInventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DistributorInventoryService {
    @Autowired
    DistributorInventoryRepository distributorInventoryRepository;

    /*public Integer getStockCount(Long upc) {
        DistributorInventory stock = distributorInventoryRepository.findByUpc(upc);
        return (stock != null) ? Integer.valueOf(stock.getStock_status()) : null;
    }*/

 /*   private static final Logger logger = LoggerFactory.getLogger(DistributorInventoryService.class);

    public ResponseEntity<String> getStockStatusResponseByUpc(Long upc) {
        try {
            String stockStatus = distributorInventoryRepository.findById(upc);

            if (stockStatus != null) {
                logger.info("Stock status found for UPC {}: {}", upc, stockStatus);
                return ResponseEntity.ok(stockStatus);
            } else {
                logger.warn("Stock status not found for UPC {}", upc);
                // Handle case when upc is not found
                return ResponseEntity.status(404).body("Stock status not found for UPC " + upc);
            }
        } catch (NoSuchElementException e) {
            logger.warn("No such element found for UPC {}: {}", upc, e.getMessage(), e);
            return ResponseEntity.status(404).body("No stock information found for UPC " + upc);
        } catch (Exception e) {
            logger.error("An error occurred while getting stock status for UPC {}: {}", upc, e.getMessage(), e);
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }*/
}
