package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillEntityRepository extends JpaRepository<BillEntity, Long> {
}
