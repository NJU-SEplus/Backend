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
     * 论文关键词
     */
    private String Author_KeyWords;
    /**
     * 论文IEEE术语
     */
    private String IEEE_terms;
    /**
     * 论文INSPEC控制词术语
     */
    private String INSPEC_controlled;



    public String getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(String affiliation_id) {
        this.affiliation_id = affiliation_id;
    }

    public String getIEEEterm() {
        return IEEE_terms;
    }

    public void setIEEEterm(String IEEEterm) {
        this.IEEE_terms = IEEEterm;
    }

    public String getINSPECcontrolledTerm() {
        return INSPEC_controlled;
    }

    public void setINSPECcontrolledTerm(String INSPECcontrolledTerm) {
        this.INSPEC_controlled = INSPECcontrolledTerm;
    }

    public String getINSPECnonControlledTerm() {
        return INSPEC_nonControlled;
    }

    public void setINSPECnonControlledTerm(String INSPECnonControlledTerm) {
        this.INSPEC_nonControlled= INSPECnonControlledTerm;
    }

    /**
     * 论文INSPEC非控制词术语
     */
    private String INSPEC_nonControlled;

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

    public String getKeyWord() {
        return Author_KeyWords;
    }

    public void setKeyWord(String keyWord) {
        Author_KeyWords= keyWord;
    }

    private String affiliation_id;

    private String author_id;

    public DocumentSummaryVO(String title, String authors, String publication_Year, String DOI, String affiliations, String author_KeyWords, String IEEE_terms, String INSPEC_controlled, String INSPEC_nonControlled,String affiliation_id,String author_id) {
        Title = title;
        Authors = authors;
        Publication_Year = publication_Year;
        this.DOI = DOI;
        Affiliations = affiliations;
        Author_KeyWords = author_KeyWords;
        this.IEEE_terms = IEEE_terms;
        this.INSPEC_controlled = INSPEC_controlled;
        this.INSPEC_nonControlled = INSPEC_nonControlled;
        this.affiliation_id=affiliation_id;
        this.author_id=author_id;
    }
}
