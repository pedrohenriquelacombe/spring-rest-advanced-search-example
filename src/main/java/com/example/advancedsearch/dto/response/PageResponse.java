package com.example.advancedsearch.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResponse<T> {

    private List<T> content;
    private int totalPages;
    private int currentPage;
    private long totalElements;

}
