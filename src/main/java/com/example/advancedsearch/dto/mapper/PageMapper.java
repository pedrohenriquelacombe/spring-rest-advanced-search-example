package com.example.advancedsearch.dto.mapper;

import com.example.advancedsearch.dto.response.PageResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageMapper {

    public static <T> PageResponse<T> toPageResponse(Page<T> page) {
        return new PageResponse<>(
                page.getContent(),
                page.getTotalPages(),
                page.getNumber(),
                page.getTotalElements(),
                page.isFirst(),
                page.isLast());
    }

}
