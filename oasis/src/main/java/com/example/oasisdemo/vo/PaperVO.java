package com.example.oasisdemo.vo;

import java.util.List;

public class PaperVO {
    /**
     * 论文id
     */
    private String doi;

    /**
     * 论文标题
     */
    private String title;

    /**
     * 论文被引数
     */
    private int citation;

    /**
     * 论文引用数
     */
    private List<String> citedPapers;

    public String getPaper_id() {
        return doi;
    }

    public void setPaper_id(String doi) {
        this.doi = doi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCitation() {
        return citation;
    }

    public void setCitation(int citation) {
        this.citation = citation;
    }

    public List<String> getCitedPapers() {
        return citedPapers;
    }

    public void setCitedPapers(List<String> citedPapers) {
        this.citedPapers = citedPapers;
    }
}
