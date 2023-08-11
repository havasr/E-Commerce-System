package com.allianz.ecommerceproject.database.repository;

import com.allianz.ecommerceproject.database.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByUuid(UUID uuid);

    List<PersonEntity> findAllByNameStartingWith(String key);

    List<PersonEntity> findAllByNameContainsIgnoreCase(String key);


    List<PersonEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);


    long deleteByUuid(UUID uuid);


}
