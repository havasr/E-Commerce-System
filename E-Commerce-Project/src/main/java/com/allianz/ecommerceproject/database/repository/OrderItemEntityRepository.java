package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity, Long> {
}
