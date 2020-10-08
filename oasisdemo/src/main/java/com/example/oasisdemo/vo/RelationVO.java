package com.example.oasisdemo.vo;

public class RelationVO {
    /**
     * 该关系A的作者名
     */
    private String a_name;
    /**
     * 该关系A的作者id
     */
    private int a_id;
    /**
     * 该关系A的机构名
     */
    private String a_affiliation;

    /**
     * 该关系B的作者名
     */
    private String b_name;
    /**
     * 该关系B的作者id
     */
    private int b_id;
    /**
     * 该关系B的机构名
     */
    private String b_affiliation;

    /**
     * 该关系强弱
     */
    private int relation;

    /**
     * 合作的文章名，以;分隔的string
     */
    private String coworkpapers;

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_affiliation() {
        return a_affiliation;
    }

    public void setA_affiliation(String a_affiliation) {
        this.a_affiliation = a_affiliation;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_affiliation() {
        return b_affiliation;
    }

    public void setB_affiliation(String b_affiliation) {
        this.b_affiliation = b_affiliation;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public String getCoworkpapers() {
        return coworkpapers;
    }

    public void setCoworkpapers(String coworkpapers) {
        this.coworkpapers = coworkpapers;
    }
}
