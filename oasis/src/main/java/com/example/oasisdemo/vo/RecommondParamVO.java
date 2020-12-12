package com.example.oasisdemo.vo;
import java.util.List;
public class RecommondParamVO {
    /**
     * 文章名称
     */
    private String documentName;

    /**
     * 作者姓名
     */
    private String authorName;


    /**
     * 作者id
     */
    private String authorID;

    /**
     * 机构名称
     */
    private List<String> affiliationName;

    /**
     * 机构id
     */
    private List<String> affiliationID;



    /**
     * 作者曾发文的DOI
     */
    private List<String> otherDocumentDOI;



    /**
     * 文章关键词
     */
    private List<String> keyword;


    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public List<String> getAffiliationName() {
        return affiliationName;
    }

    public void setAffiliationName(List<String> affiliationName) {
        this.affiliationName = affiliationName;
    }

    public List<String> getAffiliationID() {
        return affiliationID;
    }

    public void setAffiliationID(List<String> affiliationID) {
        this.affiliationID = affiliationID;
    }

    public List<String> getOtherDocumentDOI() {
        return otherDocumentDOI;
    }

    public void setOtherDocumentDOI(List<String> otherDocumentDOI) {
        this.otherDocumentDOI = otherDocumentDOI;
    }

    public List<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }
}
