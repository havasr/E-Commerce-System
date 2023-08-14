package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.CustomerEntity;
import com.allianz.ecommerceproject.util.dbutil.IBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerEntityRepository extends IBaseRepository<CustomerEntity> {
}
