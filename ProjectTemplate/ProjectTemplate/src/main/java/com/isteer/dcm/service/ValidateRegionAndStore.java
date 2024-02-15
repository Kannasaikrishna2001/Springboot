package com.isteer.dcm.service;

import com.isteer.dcm.constants.DCMConstants;
import com.isteer.dcm.constants.DCMConstants;
import com.isteer.dcm.entity.RegionalStores;
import com.isteer.dcm.repository.RegionalStoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ValidateRegionAndStore {

    private static final Logger logger = LoggerFactory.getLogger(ValidateRegionAndStore.class);

    @Autowired
    RegionalStoreRepository regionalStoreRepository;

    public String validateRegionAndStore(int regionId, String regionName, int storeId, String storeName) {
        String status = null;
        try {
            RegionalStores regionalStore = regionalStoreRepository.findByRegionIdAndRegionName(regionId, regionName, storeId, storeName);
            if (regionalStore != null) {
                if (regionalStore.getStoreId() == storeId && regionalStore.getRegionName().equals(regionName)) {
                    status = DCMConstants.VALID_REGION_AND_STORE;
                } else {
                    status = DCMConstants.INVALID_REGION_AND_STORE;
                }
            } else {
                // Handle the case when regionalStore is null (not found)
                status = DCMConstants.INVALID_REGION_AND_STORE;
            }
        } catch (Exception e) {
            logger.error("An error occurred during region and store validation" + e.getMessage());
            status = DCMConstants.FAILURE;
        }
        return status;
    }
}
