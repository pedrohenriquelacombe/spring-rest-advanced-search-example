package com.example.advancedsearch.dto.response;

import java.util.List;

public record PageResponse<T>(
        List<T> content,
        int totalPages,
        int currentPage,
        long totalElements,
        boolean first,
        boolean last) {
}
