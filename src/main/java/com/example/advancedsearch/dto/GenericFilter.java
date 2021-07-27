package com.example.advancedsearch.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;
import org.springframework.util.ObjectUtils;

@Getter
@Setter
public abstract class GenericFilter {

    private int pageSize;
    private int pageNumber;

    private String sortBy;
    private String orderBy;

    public GenericFilter() {
        this.pageSize = Integer.MAX_VALUE;
        this.orderBy = "ASC";
    }

    @JsonIgnore
    public Sort getSort() {
        if (!ObjectUtils.isEmpty(this.sortBy)) {
            return this.orderBy.equalsIgnoreCase("DESC") ? Sort.by(this.sortBy).descending() : Sort.by(this.sortBy).ascending();
        }
        return Sort.unsorted();
    }

}
