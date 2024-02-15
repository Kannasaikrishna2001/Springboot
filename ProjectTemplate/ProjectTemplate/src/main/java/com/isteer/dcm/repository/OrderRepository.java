package com.isteer.dcm.repository;
import com.isteer.dcm.entity.OrdersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<OrdersTable, Long> {

}
