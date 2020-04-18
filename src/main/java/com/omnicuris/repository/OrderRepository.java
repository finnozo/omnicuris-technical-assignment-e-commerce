package com.omnicuris.repository;

import com.omnicuris.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByIdAndActiveTrue(Long orderId);

    List<Order> findByEmailIdAndActiveTrue(String emailId);
}
