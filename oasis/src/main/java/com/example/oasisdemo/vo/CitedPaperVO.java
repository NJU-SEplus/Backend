package com.example.oasisdemo.vo;

public class CitedPaperVO {
    /**
     * 论文标题
     */
    private String title;

    /**
     * 论文编号
     */
    private String order;
    /**
     * IEEE信息
     */
    private String IEEEInfo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIEEEInfo() {
        return IEEEInfo;
    }

    public String getOrder() {
        return order;
    }


    public void setOrder(String order) {
        this.order = order;
    }

    public void setIEEEInfo(String IEEEInfo) {
        this.IEEEInfo = IEEEInfo;
    }

    public CitedPaperVO(String order,String IEEEInfo,String title ) {
        this.title = title;
        this.order = order;
        this.IEEEInfo = IEEEInfo;
    }

}
