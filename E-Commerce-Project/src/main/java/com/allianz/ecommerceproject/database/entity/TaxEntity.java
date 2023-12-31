package com.allianz.ecommerceproject.database.entity;

import com.allianz.ecommerceproject.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table
public class TaxEntity extends BaseEntity {

    @Column
    private String name;

    @Column(unique = true)
    private String code;

    @Column
    private BigDecimal rate;

}

