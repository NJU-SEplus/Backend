package com.example.oasisdemo.vo;

import java.util.List;

public class AuthorInfoVO {
    /**
     * 作者id
     */
    private String author_id;

    /**
     * 作者姓名
     */
    private String author_name;

    /**
     * 作者头像
     */
    private String author_avatar;

    /**
     * 作者别名
     */
    private List<String> author_alias;

    /**
     * 作者论文数
     */
    private int author_paperCount;

    /**
     * 作者被引数
     */
    private int citation;

    /**
     * 作者机构
     */
    private List<String> affiliation;

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_avatar() {
        return author_avatar;
    }

    public void setAuthor_avatar(String author_avatar) {
        this.author_avatar = author_avatar;
    }

    public List<String> getAuthor_alias() {
        return author_alias;
    }

    public void setAuthor_alias(List<String> author_alias) {
        this.author_alias = author_alias;
    }

    public int getAuthor_paperCount() {
        return author_paperCount;
    }

    public void setAuthor_paperCount(int author_paperCount) {
        this.author_paperCount = author_paperCount;
    }

    public int getCitation() {
        return citation;
    }

    public void setCitation(int citation) {
        this.citation = citation;
    }

    public List<String> getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(List<String> affiliation) {
        this.affiliation = affiliation;
    }
}
