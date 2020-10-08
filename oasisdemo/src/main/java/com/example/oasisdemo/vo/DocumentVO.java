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
     * 论文开始页码
     */
    private Integer StartPage;
    /**
     * 论文结束页码
     */
    private Integer EndPage;
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
    private String KeyWords;
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

    private String affiliation_id;

    public String getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(String affiliation_id) {
        this.affiliation_id = affiliation_id;
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

    public Integer getStartPage() {
        return StartPage;
    }

    public void setStartPage(Integer startPage) {
        StartPage = startPage;
    }

    public Integer getEndPage() {
        return EndPage;
    }

    public void setEndPage(Integer endPage) {
        EndPage = endPage;
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
        return KeyWords;
    }

    public void setKeyWord(String keyWord) {
        KeyWords = keyWord;
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

    public String getINSPECcontrolledTerm() {
        return INSPECcontrolledTerm;
    }

    public void setINSPECcontrolledTerm(String INSPECcontrolledTerm) {
        this.INSPECcontrolledTerm = INSPECcontrolledTerm;
    }

    public String getINSPECnonControlledTerm() {
        return INSPECnonControlledTerm;
    }

    public void setINSPECnonControlledTerm(String INSPECnonControlledTerm) {
        this.INSPECnonControlledTerm = INSPECnonControlledTerm;
    }

    public Integer getCitationCount() {
        return CitationCount;
    }

    public void setCitationCount(Integer citationCount) {
        CitationCount = citationCount;
    }

    public Integer getReferenceCount() {
        return ReferenceCount;
    }

    public void setReferenceCount(Integer referenceCount) {
        ReferenceCount = referenceCount;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getIdentified() {
        return Identified;
    }

    public void setIdentified(String identified) {
        Identified = identified;
    }

    /**
     * 论文INSPEC控制词术语
     */
    private String INSPECcontrolledTerm;
    /**
     * 论文INSPEC非控制词术语
     */
    private String INSPECnonControlledTerm;
    /**
     * 论文被引用次数
     */
    private Integer CitationCount;
    /**
     * 论文被参考次数
     */
    private Integer ReferenceCount;
    /**
     * 论文出版方
     */
    private String Publisher;
    /**
     * 论文识别码/会议
     */
    private String Identified;

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

    public String getKeyWords() {
        return KeyWords;
    }

    public void setKeyWords(String keyWords) {
        KeyWords = keyWords;
    }

    public String getIEEEterms() {
        return IEEEterms;
    }

    public void setIEEEterms(String IEEEterms) {
        this.IEEEterms = IEEEterms;
    }
}
