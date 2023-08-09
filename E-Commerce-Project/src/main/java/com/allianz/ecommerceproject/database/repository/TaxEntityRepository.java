package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.TaxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxEntityRepository extends JpaRepository<TaxEntity, Long> {
}
