package com.example.advancedsearch.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.ObjectUtils;

@Getter
@Setter
public abstract class GenericFilter {

    private static final String DEFAULT_ORDER = "ASC";

    @JsonAlias("size")
    private int pageSize;

    @JsonAlias("number")
    private int pageNumber;

    @JsonAlias("sort")
    private String sortBy;

    @JsonAlias("order")
    private String orderBy;

    public GenericFilter() {
        this.pageSize = 5;
        this.orderBy = DEFAULT_ORDER;
    }

    @JsonIgnore
    public Pageable toPageable() {
        return PageRequest.of(this.pageNumber, this.pageSize, this.getSort());
    }

    private Sort getSort() {
        if (ObjectUtils.isEmpty(this.sortBy)) {
            return Sort.unsorted();
        }

        return this.orderBy.equalsIgnoreCase(DEFAULT_ORDER) ? Sort.by(this.sortBy).ascending() : Sort.by(this.sortBy).descending();
    }

}
