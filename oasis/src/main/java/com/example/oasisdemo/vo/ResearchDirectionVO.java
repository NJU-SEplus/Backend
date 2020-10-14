package com.example.oasisdemo.vo;
import com.example.oasisdemo.vo.AuthorVO;
import com.example.oasisdemo.vo.DocumentSummaryVO;

import java.util.List;
public class ResearchDirectionVO {

    /**
     * 该方向id
     */
    private int id;
    /**
     * 该方向热度
     */
    private int heat;
    /**
     * 该方向名称
     */
    private String name;
    /**
     * 该方向相关作者数
     */
    private int authorCount;
    /**
     * 该方向相关机构数
     */
    private int affCount;

    public int getAffCount() {
        return affCount;
    }

    public void setAffCount(int affCount) {
        this.affCount = affCount;
    }

    /**
     * 该方向文章数
     */
    private int docuCount;

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

    public List<Integer> getDocuCountByYear() {
        return docuCountByYear;
    }

    public void setDocuCountByYear(List<Integer> docuCountByYear) {
        this.docuCountByYear = docuCountByYear;
    }

    public List<AuthorVO> getAuthorOfDirection() {
        return AuthorOfDirection;
    }

    public void setAuthorOfDirection(List<AuthorVO> authorOfDirection) {
        AuthorOfDirection = authorOfDirection;
    }

    public List<DocumentSummaryVO> getDocuOfDirection() {
        return DocuOfDirection;
    }

    public void setDocuOfDirection(List<DocumentSummaryVO> docuOfDirection) {
        DocuOfDirection = docuOfDirection;
    }

    /**
     * 该方向按年发文数，8个int从2012到2020
     */
    private List<Integer> docuCountByYear;
    /**
     * 该方向的作者，AuthorVO将会包含作者姓名，作者发文数量，作者机构（可能为多个，为原数据的全部）
     */
    private List<AuthorVO> AuthorOfDirection;
    /**
     * 该方向的文章
     */
    private List<DocumentSummaryVO> DocuOfDirection;
}
