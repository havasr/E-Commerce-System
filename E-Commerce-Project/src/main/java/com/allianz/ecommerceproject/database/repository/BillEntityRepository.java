package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BillEntityRepository extends JpaRepository<BillEntity, Long> {
    Optional<BillEntity> findByUuid(UUID uuid);
}
