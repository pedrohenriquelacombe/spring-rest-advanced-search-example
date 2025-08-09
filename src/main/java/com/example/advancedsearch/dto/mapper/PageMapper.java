package com.example.advancedsearch.dto.mapper;

import com.example.advancedsearch.dto.response.PageResponse;
import org.springframework.data.domain.Page;

public class PageMapper {

    public static <T> PageResponse<T> toPageResponse(Page<T> page) {
        var response = new PageResponse<T>();

        response.setContent(page.getContent());
        response.setTotalPages(page.getTotalPages());
        response.setCurrentPage(page.getNumber());
        response.setTotalElements(page.getTotalElements());
        response.setFirst(page.isFirst());
        response.setLast(page.isLast());

        return response;
    }

}
