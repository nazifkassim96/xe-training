package com.OrderWand.orderWandAPI.Repository;

import com.OrderWand.orderWandAPI.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long>{
}
