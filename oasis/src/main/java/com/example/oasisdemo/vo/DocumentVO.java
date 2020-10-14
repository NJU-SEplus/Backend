package com.example.oasisdemo.vo;

public class DocumentVO {
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
    private Integer PublicationYear;
    /**
     * 出版物名称
     */
    private String PublicationTitle;
    /**
     * 论文DOI
     */
    private String DOI;
    /**
     * 论文机构
     */
    private String Affiliations;
    /**
     * 论文概要
     */
    private String Abstract;
    /**
     * 论文PDF链接
     */
    private String PDFlink;
    /**
     * 论文IEEE术语
     */
    private String IEEEterms;

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

    public Integer getPublicationYear() {
        return PublicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        PublicationYear = publicationYear;
    }

    public String getPublicationTitle() {
        return PublicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        PublicationTitle = publicationTitle;
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

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getPDFlink() {
        return PDFlink;
    }

    public void setPDFlink(String PDFlink) {
        this.PDFlink = PDFlink;
    }

    public String getIEEEterm() {
        return IEEEterms;
    }

    public void setIEEEterm(String IEEEterm) {
        this.IEEEterms = IEEEterm;
    }

    public Integer getReferenceCount() {
        return ReferenceCount;
    }

    public void setReferenceCount(Integer referenceCount) {
        ReferenceCount = referenceCount;
    }

    /**
     * 论文被参考次数
     */
    private Integer ReferenceCount;

    public String getAuthors() {
        return Authors;
    }

    public void setAuthors(String authors) {
        Authors = authors;
    }

    public String getAffiliations() {
        return Affiliations;
    }

    public void setAffiliations(String affiliations) {
        Affiliations = affiliations;
    }

    public String getIEEEterms() {
        return IEEEterms;
    }

    public void setIEEEterms(String IEEEterms) {
        this.IEEEterms = IEEEterms;
    }

    public DocumentVO(String title, String authors, Integer publicationYear, String publicationTitle, String DOI, String affiliations, String anAbstract, String PDFlink, String IEEEterms, Integer referenceCount) {
        Title = title;
        Authors = authors;
        PublicationYear = publicationYear;
        PublicationTitle = publicationTitle;
        this.DOI = DOI;
        Affiliations = affiliations;
        Abstract = anAbstract;
        this.PDFlink = PDFlink;
        this.IEEEterms = IEEEterms;
        ReferenceCount = referenceCount;
    }

    public DocumentVO() {
    }
}
