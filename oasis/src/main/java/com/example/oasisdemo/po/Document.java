package com.example.oasisdemo.po;

public class Document {
    /**
     * 论文题目
     */
    private String Title;
    /**
     * 论文作者
     */
    private String Author;
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
    private String Affiliation;
    /**
     * 论文关键词
     */
    private String KeyWord;
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
    private String IEEEterm;
    private int affiliation_id;

    public int getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(int affiliation_id) {
        this.affiliation_id = affiliation_id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
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
        return Affiliation;
    }

    public void setAffiliation(String affiliation) {
        Affiliation = affiliation;
    }

    public String getKeyWord() {
        return KeyWord;
    }

    public void setKeyWord(String keyWord) {
        KeyWord = keyWord;
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
        return IEEEterm;
    }

    public void setIEEEterm(String IEEEterm) {
        this.IEEEterm = IEEEterm;
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
}
