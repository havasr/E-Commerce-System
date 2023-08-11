package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.SettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SettingEntityRepository extends JpaRepository<SettingEntity, Long> {

    Optional<SettingEntity> findByUuid(UUID uuid);
}
