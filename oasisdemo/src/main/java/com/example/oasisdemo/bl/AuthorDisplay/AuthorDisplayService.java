package com.example.oasisdemo.bl.AuthorDisplay;

import com.example.oasisdemo.vo.ResponseVO;

public interface AuthorDisplayService {
    /**
     * 查询发文量前十的作者，返回一个List<AuthorVO>对象
     * @return
     */
    ResponseVO searchTopTenPublicationAuthor();
    /**
     * 根据id展示作者画像
     * @param id
     * @return
     */
    ResponseVO searchAuthorPortraitById(int id);
    /**
     * 根据姓名搜索作者
     * @param name
     * @return
     */
    ResponseVO searchAuthorByName(String name);
    /**
     * 展示所有作者名称
     * @param
     * @return
     */
    ResponseVO searchAllAuthor();

    /**
     * 获取作者H-index
     * @param id
     * @return
     */
    ResponseVO getAuthorHindexById(int id);

    /**
     * 获取合作者
     * @param id
     * @return
     */
    ResponseVO getAuthorPartnersById(int id);

    /**
     * 根据作者id查询关系
     * @param
     * @return List<RelationVO>
     */
    ResponseVO showRelationByAuthorId(int id);

    /**
     * 根据A、B作者id查询关系
     * @param
     * @return List<RelationVO>
     */
    ResponseVO showABRelation(int Aid,int Bid);
    /**
     * 按热度展示前一百的作者
     * @param
     * @return List<AuthorPortraitVO> size为100
     */
    ResponseVO showAuthorByHeat();
}
