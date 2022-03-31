package com.system.restaurant.controller;


public class Page {
    public int page;
    public int size = 10;
    public int offset;
    private int total;
    private int groupSize = 10;

    private int begin;
    private int end;

    public int getBegin() {
        return 1 + ((page-1) / groupSize);
    }

    public int getEnd() {
        return groupSize * getBegin();
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getOffset() {
        return page * size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", size=" + size +
                ", offset=" + getOffset() +
                ", total=" + total +
                ", groupSize=" + groupSize +
                ", begin=" + getBegin() +
                ", end=" + getEnd() +
                '}';
    }
}
