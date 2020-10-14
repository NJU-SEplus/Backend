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
     * 作者机构id
     */
    private String affiliation_id;

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

    public String getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(String affiliation_id) {
        this.affiliation_id = affiliation_id;
    }

}
