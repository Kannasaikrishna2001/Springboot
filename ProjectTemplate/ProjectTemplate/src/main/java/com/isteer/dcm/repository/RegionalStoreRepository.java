package com.isteer.dcm.repository;

import com.isteer.dcm.entity.RegionalStores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionalStoreRepository extends JpaRepository<RegionalStores,Long> {

    @Query(value = "SELECT region_Id, region_Name, store_Id, store_Name FROM RegionalStores WHERE region_Id = :region_Id AND region_Name = :region_Name", nativeQuery = true)
    RegionalStores findByRegionIdAndRegionName(@Param("region_Id") int region_Id, @Param("region_Name") String region_Name);

   }


