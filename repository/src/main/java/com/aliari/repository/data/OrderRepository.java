package com.aliari.repository.data;

import com.aliari.repository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
	List<Order> findByCustomerId(UUID customerId);
}
