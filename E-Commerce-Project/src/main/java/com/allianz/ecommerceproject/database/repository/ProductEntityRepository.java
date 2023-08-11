package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.PersonEntity;
import com.allianz.ecommerceproject.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByUuid(UUID uuid);

}
