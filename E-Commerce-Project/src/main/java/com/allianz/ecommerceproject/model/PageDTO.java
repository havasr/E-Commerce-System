package com.allianz.ecommerceproject.model;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class PageDTO<DTO extends BaseDTO> {

    private int totalPages;

    private long totalElements;

    private int number;

    private int size;

    private int numberOfElements;

    private List<DTO> content;
    private boolean hasContent;
    private Sort sort;


}