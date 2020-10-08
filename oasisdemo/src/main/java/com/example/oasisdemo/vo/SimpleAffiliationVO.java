package com.example.oasisdemo.vo;

public class SimpleAffiliationVO {
    /**
     * 该机构id
     */
    private int affiliation_id;
    /**
     * 该机构最简名，如原数据Dep. of computer sci. of Nanjing University，Jiangsu，China化简为Nanjing University
     */
    private String affiliation_name;
    /**
     * 该机构国别,未识别的为“Unknown"
     */
    private String country;
    /**
     * 该机构类型，0为院校（如University，College等），1为实验室（如Lab)，2为企业机构，3为其它
     */
    private int kindOfAff;

    private int heat;

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getKindOfAff() {
        return kindOfAff;
    }

    public void setKindOfAff(int kindOfAff) {
        this.kindOfAff = kindOfAff;
    }

    public int getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(int affiliation_id) {
        this.affiliation_id = affiliation_id;
    }

    public String getAffiliation_name() {
        return affiliation_name;
    }

    public void setAffiliation_name(String affiliation_name) {
        this.affiliation_name = affiliation_name;
    }
}
