package com.example.oasisdemo.vo;

public class DocumentSummaryVO {
    /**
     * 论文题目
     */
    private String Title;
    /**
     * 论文作者
     */
    private String Authors;
    /**
     * 论文出版年份
     */
    private String Publication_Year;
    /**
     * 论文DOI
     */
    private String DOI;
    /**
     * 论文机构
     */
    private String Affiliations;
    /**
     * 论文IEEE术语
     */
    private String IEEE_terms;


    public String getIEEEterm() {
        return IEEE_terms;
    }

    public void setIEEEterm(String IEEEterm) {
        this.IEEE_terms = IEEEterm;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Authors;
    }

    public void setAuthor(String author) {
        Authors = author;
    }

    public String getPublicationYear() {
        return Publication_Year;
    }

    public void setPublicationYear(String publicationYear) {
        Publication_Year = publicationYear;
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public String getAffiliation() {
        return Affiliations;
    }

    public void setAffiliation(String affiliation) {
        Affiliations = affiliation;
    }

    private String author_id;

    public DocumentSummaryVO(String title, String authors, String publication_Year, String DOI, String affiliations, String IEEE_terms, String author_id) {
        Title = title;
        Authors = authors;
        Publication_Year = publication_Year;
        this.DOI = DOI;
        Affiliations = affiliations;
        this.IEEE_terms = IEEE_terms;
        this.author_id = author_id;
    }

    public DocumentSummaryVO() {
    }
}
