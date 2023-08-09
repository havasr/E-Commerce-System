package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.SettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingEntityRepository extends JpaRepository<SettingEntity, Long> {
}
