package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerEntityRepository extends JpaRepository<SellerEntity, Long> {
}
