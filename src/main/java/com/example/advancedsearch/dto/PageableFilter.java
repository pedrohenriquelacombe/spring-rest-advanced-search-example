package com.example.advancedsearch.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.ObjectUtils;

@Getter
@Setter
public abstract class PageableFilter {

    private static final String DEFAULT_ORDER = "ASC";

    private int size;
    private int page;
    private String sort;
    private String order;

    public PageableFilter() {
        this.size = 5;
        this.order = DEFAULT_ORDER;
    }

    @JsonIgnore
    public Pageable toPageable() {
        return PageRequest.of(this.page, this.size, this.buildSort());
    }

    private Sort buildSort() {
        if (ObjectUtils.isEmpty(this.sort)) {
            return Sort.unsorted();
        }

        var direction = this.order.equalsIgnoreCase(DEFAULT_ORDER) ? Sort.Direction.ASC : Sort.Direction.DESC;

        return Sort.by(direction, this.sort);
    }

}
