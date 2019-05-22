package com.util;

import java.util.Collections;
import java.util.List;
import org.springframework.util.NumberUtils;

public class GridResultdd {
    private Long total;
    private List rows;
    private List footer;

    public GridResultdd() {
    }

    public GridResultdd(List rows, Long total) {
        this.total = total;
        this.rows = rows;
    }

    public GridResultdd(List rows, Long total, List footer) {
        this.total = total;
        this.rows = rows;
        this.footer = footer;
    }

    public GridResultdd(List rows) {
        if (rows != null) {
            this.total = (Long)NumberUtils.convertNumberToTargetClass(rows.size(), Long.class);
            this.rows = rows;
        }

    }

    public static GridResultdd getEmptyResult() {
        return new GridResultdd(Collections.EMPTY_LIST);
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return this.rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public List getFooter() {
        return this.footer;
    }

    public void setFooter(List footer) {
        this.footer = footer;
    }
}
