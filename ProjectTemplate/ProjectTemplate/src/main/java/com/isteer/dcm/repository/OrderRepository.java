package com.isteer.dcm.repository;
import com.isteer.dcm.entity.OrdersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<OrdersTable, Long> {
    List<OrdersTable> findByOrderStatusIn(List<String> statuses);
}
