package com.cjx913.es.entity.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude()
public class Pagination {
    private Long start;
    private Long size;
    private String searchtext;
    private String sortorder;

    public Pagination() {
    }

    public Pagination(Long start, Long size, String searchtext, String sortorder) {
        this.start = start;
        this.size = size;
        this.searchtext = searchtext;
        this.sortorder = sortorder==null?null:sortorder.toUpperCase();
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getSearchtext() {
        return searchtext;
    }

    public void setSearchtext(String searchtext) {
        this.searchtext = searchtext;
    }

    public String getSortorder() {
        return sortorder;
    }

    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }
}
