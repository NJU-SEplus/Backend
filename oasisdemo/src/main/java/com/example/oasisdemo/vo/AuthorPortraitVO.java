package com.example.oasisdemo.vo;

import com.example.oasisdemo.blImpl.AuthorDisplay.AuthorDisplayServiceImpl;
import com.example.oasisdemo.data.AuthorDisplay.AuthorDisplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AuthorPortraitVO {
    /**
     * 作者id
     */
    private Integer author_id;

    /**
     * 作者name
     */
    private String author_name;

    /**
     * 机构id
     */
     private Integer affiliation_id;

    /**
     * 机构
     */
    private String affiliation;

    /**
     * 发表论文数
     */
    private Integer publication_count;

    /**
     * 年份列表
     */
    private List<String> PublicationYears;

    /**
     * 论文列表
     */
    private List<String> PaperTitles;

    /**
     * 关键词
     */
    private HashMap<String,Integer> keywords;

    /**
     * 年份统计
     */
    private HashMap<String,Integer> PublicationYearCount;
    /**
     * 热度
     */
    private Integer heat;

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    public HashMap<String, Integer> getPublicationYearCount() {
        return PublicationYearCount;
    }

    public void setPublicationYearCount(HashMap<String, Integer> publicationYearCount) {
        PublicationYearCount = publicationYearCount;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Integer getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(Integer affiliation_id) {
        this.affiliation_id = affiliation_id;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public Integer getPublication_count() {
        return publication_count;
    }

    public void setPublication_count(Integer publication_count) {
        this.publication_count = publication_count;
    }

    public List<String> getPublicationYears() {
        return PublicationYears;
    }

    public void setPublicationYears(List<String> publicationYears) {
        PublicationYears = publicationYears;
    }

    public List<String> getPaperTitles() {
        return PaperTitles;
    }

    public void setPaperTitles(List<String> paperTitles) {
        PaperTitles = paperTitles;
    }

    public HashMap<String, Integer> getKeywords() {
        return keywords;
    }

    public void setKeywords(HashMap<String, Integer> keywords) {
        this.keywords = keywords;
    }

    public AuthorPortraitVO(Integer author_id, String author_name, Integer affiliation_id, String affiliation, Integer publication_count,
                            String publicationYears, String paperTitles, String keywords,Integer heat) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.affiliation_id = affiliation_id;
        this.affiliation = affiliation;
        this.publication_count = publication_count;
        PublicationYears = generatePublicationYears(publicationYears);
        PaperTitles = generateTitles(paperTitles);
        this.keywords = generateKeywords(keywords);
        this.PublicationYearCount = generateYearCount(publicationYears);
        this.heat = heat;
    }

    private HashMap<String, Integer> generateYearCount(String publicationYears) {
        String[] years=publicationYears.split(" ; ");
        HashMap<String,Integer> yearCount=new HashMap<>();
        for(String year:years){
            if(yearCount.containsKey(year))
                yearCount.put(year,yearCount.get(year)+1);
            else
                yearCount.put(year,1);
        }
        return yearCount;
    }

    public List<String> generatePublicationYears(String pubyears){
        String[] YearList = pubyears.split(" ; ");
        return Arrays.asList(YearList);
    }

    public List<String> generateTitles(String titles){
        String[] TitleList = titles.split(" ; ");
        return Arrays.asList(TitleList);
    }

    public HashMap<String,Integer> generateKeywords(String keywords){
        if (keywords==null)
            return null;
        String[] wordList = keywords.split(",");
        HashMap<String,Integer> wordMap = new HashMap<String,Integer>();
        for(String word:wordList){
            if(wordMap.containsKey(word))
                wordMap.put(word,wordMap.get(word)+1);
            else
                wordMap.put(word,1);
        }
        return wordMap;
    }
}
