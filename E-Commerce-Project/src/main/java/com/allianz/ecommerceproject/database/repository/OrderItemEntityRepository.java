package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity, Long> {
    Optional<OrderItemEntity> findByUuid(UUID uuid);
}
