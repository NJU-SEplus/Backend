package com.example.oasisdemo.vo;

public class ResearchDirectionVO {
    /**
     * 年份
     */
    private String year;

    /**
     * 关键词列表
     */
    private String[] direction;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String[] getDirection() {
        return direction;
    }

    public void setDirection(String[] direction) {
        this.direction = direction;
    }
}
