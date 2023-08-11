package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.TaxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaxEntityRepository extends JpaRepository<TaxEntity, Long> {
    Optional<TaxEntity> findByUuid(UUID uuid);

}
