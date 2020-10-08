package com.example.oasisdemo.vo;

public class AuthorVO {
    /**
     * 作者id
     */
    private Integer author_id;
    /**
     * 作者姓名
     */
    private String author_name;
    /**
     * 作者机构
     */
    private String affiliation;
    /**
     * 发文数量
     */
    private Integer publication_count;
    /**
     * 机构id
     */
    private Integer affiliation_id;
    /**
     * 热度
     */
    private Integer heat;

    /**
     * 关键词
     */
    private String Keywords;


    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public Integer getPublication_count() {
        return publication_count;
    }

    public void setPublication_count(Integer publication_count) {
        this.publication_count = publication_count;
    }


    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }



    public String getKeyword() {
        return Keywords;
    }

    public void setKeyword(String keyword) {
        this.Keywords = keyword;
    }

    public Integer getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(Integer affiliation_id) {
        this.affiliation_id = affiliation_id;
    }

}
