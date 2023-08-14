package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.OrderEntity;
import com.allianz.ecommerceproject.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderEntityRepository extends IBaseRepository<OrderEntity> {
}
