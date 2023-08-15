package com.allianz.ecommerceproject.util.dbutil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface IBaseRepository<Entity extends BaseEntity> extends JpaRepository<Entity, Long>,
        JpaSpecificationExecutor<Entity> {
    Optional<Entity> findByUuid(UUID uuid);
}
