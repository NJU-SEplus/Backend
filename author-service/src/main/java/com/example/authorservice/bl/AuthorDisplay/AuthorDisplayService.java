package com.example.authorservice.bl.AuthorDisplay;

import com.example.authorservice.vo.ResponseVO;

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
    ResponseVO getAuthorInfoByName(String name);
}
