package com.example.oasisdemo.po;

import com.example.oasisdemo.vo.AuthorVO;
import com.example.oasisdemo.vo.DocumentSummaryVO;

import java.util.List;

public class Affiliation {
    /**
     * 该机构id
     */
    private int id;
    /**
     * 该机构热度
     */
    private int heat;
    /**
     * 该机构最简名，如原数据Dep. of computer sci. of Nanjing University，Jiangsu，China化简为Nanjing University
     */
    private String name;
    /**
     * 该机构作者数
     */
    private int authorCount;
    /**
     * 该机构论文数
     */
    private int docuCount;
    /**
     * 该机构引用数
     */
    private int refCount;
    /**
     * 该机构引用数,长度为8的list，从2012-2019对应8个值
     */
    private List<Integer> docuCountByYear;
    /**
     * 该机构的作者，AuthorVO将会包含作者姓名，作者发文数量，作者机构（可能为多个，为原数据的全程）
     */
    private List<AuthorVO> AuthorOfAffiliation;
    /**
     * 该机构引用数最多的10篇文章，长度为10
     */
    private List<DocumentSummaryVO> mostRefDocu;
    /**
     * 该机构关键词及出现次数,格式为string，形如“{关键词1，出现次数1；关键词2，出现次数2；……}
     */
    private String keyWord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorCount() {
        return authorCount;
    }

    public void setAuthorCount(int authorCount) {
        this.authorCount = authorCount;
    }

    public int getDocuCount() {
        return docuCount;
    }

    public void setDocuCount(int docuCount) {
        this.docuCount = docuCount;
    }

    public int getRefCount() {
        return refCount;
    }

    public void setRefCount(int refCount) {
        this.refCount = refCount;
    }

    public List<Integer> getDocuCountByYear() {
        return docuCountByYear;
    }

    public void setDocuCountByYear(List<Integer> docuCountByYear) {
        this.docuCountByYear = docuCountByYear;
    }

    public List<AuthorVO> getAuthorOfAffiliation() {
        return AuthorOfAffiliation;
    }

    public void setAuthorOfAffiliation(List<AuthorVO> authorOfAffiliation) {
        AuthorOfAffiliation = authorOfAffiliation;
    }

    public List<DocumentSummaryVO> getMostRefDocu() {
        return mostRefDocu;
    }

    public void setMostRefDocu(List<DocumentSummaryVO> mostRefDocu) {
        this.mostRefDocu = mostRefDocu;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
