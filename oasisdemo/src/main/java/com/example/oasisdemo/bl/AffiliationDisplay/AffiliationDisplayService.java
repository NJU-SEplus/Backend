package com.example.oasisdemo.bl.AffiliationDisplay;

import com.example.oasisdemo.vo.ResponseVO;

public interface AffiliationDisplayService {
    /**
     * 根据机构id展示机构画像
     * @param id
     * @return
     */
    ResponseVO getAffiliationPortrait(int id);
    /**
     * 根据机构姓名搜索机构
     * @param name
     * @return
     */
    ResponseVO getAffiliationByName(String name);
    /**
     * 展示所有机构名称
     * @param
     * @return
     */
    ResponseVO showAllAffiliation();
    /**
     * 按国别展示机构数量
     * @param
     * @return 返回的信息为一个string形如{国家1,出现次数1；国家2，出现次数2；……）
     */
    ResponseVO showAffiliationByCountry();
    /**
     * 按热度展示前一百的机构
     * @param
     * @return List<AffiliationVO> size为10
     */
    ResponseVO showAffiliationByHeat();
    /**
     * 根据机构名查询关系
     * @param
     * @return List<RelationVO>
     */
    ResponseVO showRelationByName(String affiliationName);
}
