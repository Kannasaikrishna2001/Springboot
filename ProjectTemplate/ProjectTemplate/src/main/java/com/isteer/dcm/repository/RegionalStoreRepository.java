package com.isteer.dcm.repository;

import com.isteer.dcm.entity.RegionalStores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionalStoreRepository extends JpaRepository<RegionalStores,Long> {
}
