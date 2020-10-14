package com.example.oasisdemo.vo;

public class SimpleResearchDirectionVO {

    /**
     * 该方向名称
     */
    private String name;
    /**
     * 该方向id
     */
    private int id;
    /**
     * 该方向作者数
     */
    private int authorCount;
    /**
     * 该方向机构数
     */
    private int affCount;

    public int getAuthorCount() {
        return authorCount;
    }

    public void setAuthorCount(int authorCount) {
        this.authorCount = authorCount;
    }

    public int getAffCount() {
        return affCount;
    }

    public void setAffCount(int affCount) {
        this.affCount = affCount;
    }

    public int getDocCount() {
        return docCount;
    }

    public void setDocCount(int docCount) {
        this.docCount = docCount;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    /**
     * 该方向文章数
     */
    private int docCount;
    /**
     * 该方向热度
     */
    private int heat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public SimpleResearchDirectionVO(String name,int id,int authorCount,int affCount,int docCount,int heat){
        this.id=id;
        this.heat=heat;
        this.affCount=affCount;
        this.authorCount=authorCount;
        this.name=name;
        this.docCount=docCount;
    }
}
