package com.example.oasisdemo.bl.DirectionDisplay;

import com.example.oasisdemo.vo.ResponseVO;

public interface DirectionDisplayService {
    /**
     * 根据方向id展示方向画像
     * @param id
     * @return
     */
    ResponseVO getDirectionPortrait(int id);
    /**
     * 根据方向姓名搜索方向
     * @param name
     * @return
     */
    ResponseVO getDirectionByName(String name);
    /**
     * 展示所有方向名称
     * @param
     * @return
     */
    ResponseVO showAllDirection();
    /**
     * 按热度展示前十方向
     * @param
     * @return List<AffiliationVO> size为10
     */
    ResponseVO showDirectionByHeat();
}
