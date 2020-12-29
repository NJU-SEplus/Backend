package com.example.oasisdemo.vo;

import java.util.ArrayList;
import java.util.List;

public class CollaboratorVO {
    /**
     * 合作者id
     */
    private String colla_id;

    /**
     * 合作者姓名
     */
    private String colla_name;

    /**
     * 合作次数
     */
    private int colla_times;

    /**
     * 合作论文列表
     */
    List<coPaper> coPaperList;

    private class coPaper{
        /**
         * 合作论文标题
         */
        private String title;
        /**
         * 合作论文doi
         */
        private String doi;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDoi() {
            return doi;
        }

        public void setDoi(String doi) {
            this.doi = doi;
        }

        public coPaper(String paperTitle,String paperDOI){
            this.title=paperTitle;
            this.doi=paperDOI;
        }
    }

    public String getColla_id() {
        return colla_id;
    }

    public void setColla_id(String colla_id) {
        this.colla_id = colla_id;
    }

    public String getColla_name() {
        return colla_name;
    }

    public void setColla_name(String colla_name) {
        this.colla_name = colla_name;
    }

    public int getColla_times() {
        return colla_times;
    }

    public void setColla_times(int colla_times) {
        this.colla_times = colla_times;
    }

    public List<coPaper> getCoPaperList() {
        return coPaperList;
    }

    public void setCoPaperList(List<coPaper> coPaperList) {
        this.coPaperList = coPaperList;
    }

    public CollaboratorVO(String id,String name,Integer coWorkTimes,String paperTitles,String paperDOIs){
        this.colla_id=id;
        this.colla_name=name;
        this.colla_times=coWorkTimes;
        String titles[]=paperTitles.split(";");
        String dois[]=paperDOIs.split(";");
        this.coPaperList=new ArrayList<coPaper>();
        for(int i=0;i<titles.length;i++){
            this.coPaperList.add(new coPaper(titles[i],dois[i]));
        }
    }

}
