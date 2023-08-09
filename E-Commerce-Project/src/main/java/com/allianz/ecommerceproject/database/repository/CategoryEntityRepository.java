package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryEntityRepository extends JpaRepository<CategoryEntity,Long> {
}
