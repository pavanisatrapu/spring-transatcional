package com.myprojects.spring_transatcional.repository;

import com.myprojects.spring_transatcional.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
