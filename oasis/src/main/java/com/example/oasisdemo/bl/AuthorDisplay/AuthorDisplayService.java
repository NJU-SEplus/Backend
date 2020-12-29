package com.example.oasisdemo.bl.AuthorDisplay;

import com.example.oasisdemo.vo.RecommondParamVO;
import com.example.oasisdemo.vo.ResponseVO;

public interface AuthorDisplayService {
    /**
     * 按id展示作者文章列表
     * @param id
     * @return List<PaperVO>
     */
    ResponseVO getAuthorPapersById(String id);
    /**
     * 按id展示作者关键词
     * @param id
     * @return List<String>
     */
    ResponseVO getAuthorTopicsById(String id);
    /**
     * 按id展示作者信息
     * @param id
     * @return AuthorInfoVO
     */
    ResponseVO getAuthorInfoById(String id);
    /**
     * 按作者名字模糊匹配作者信息
     * @param name
     * @return AuthorInfoVO
     */
    ResponseVO getAuthorInfoByName(String name,int pageNum,int pageSize);
    /**
     * 返回发文量前十作者信息
     * @return AuthorInfoVO
     */
    ResponseVO showAuthorByPubCnt();
    /**
     * 返回热度前十作者信息
     * @return AuthorInfoVO
     */
    ResponseVO showAuthorByHeat();
    /**
     * 返回作者随时间变化兴趣点
     * @return Map<Integer,List<String>>
     */
    ResponseVO showResearchDirectionById(String id);
    /**
     * 返回论文合作者
     * @return CollaboratorVO
     */
    ResponseVO showCollaboratorsById(String id);
    /**
     * 返回引用列表
     * @return CitedPaperVO
     */
    ResponseVO showCitedPapersByDoi(String doi);
    /**
     * 返回审稿人推荐列表
     * @return Reviewers
     */
    ResponseVO reviewerRecommended(RecommondParamVO recommondParamVO);
    /**
     * 返回作者兴趣预测
     * @return Map<Integer,List<String>>
     */
    ResponseVO interestPredict(String id);
    /**
     * 返回作者兴趣预测
     * @return Map<Integer,List<String>>
     */
    ResponseVO collaboratorPredict(String id);
}
