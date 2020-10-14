package com.example.oasisdemo.data.DocumentDisplay;

import com.example.oasisdemo.vo.DocumentSummaryVO;
import com.example.oasisdemo.vo.DocumentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DocumentDisplayMapper {
    /**
     * 根据文章名搜索文章，title可能不为全名，返回一个List<DocumentSummaryVO>对象
     * @param title
     * @return
     */
    List<DocumentSummaryVO> selectDocumentSummaryVOByTitle(@Param("title") String title);
    /**
     * 根据作者名搜索文章，返回一个List<DocumentSummaryVO>对象
     * @param author
     * @return
     */
    List<DocumentSummaryVO> selectDocumentSummaryVOByAuthorName(@Param("author") String author);
    /**
     * 根据年份搜索文章，返回一个List<DocumentSummaryVO>对象
     * @param year
     * @return
     */
    List<DocumentSummaryVO> selectDocumentSummaryVOByPublicationYear(@Param("year") String year);
    /**
     * 根据机构名搜索文章，返回一个List<DocumentSummaryVO>对象
     * @param AffiliationName
     * @return
     */
    List<DocumentSummaryVO> selectDocumentSummaryVOByAffiliationName(@Param("affiliation") String AffiliationName);
    /**
     * 根据关键词搜索文章，返回一个List<DocumentSummaryVO>对象
     * @param Keyword
     * @return
     */
    List<DocumentSummaryVO> selectDocumentSummaryVOByKeyword(@Param("keyword") String Keyword);
    /**
     * 根据List信息查找电影
     * @param AuthorName
     * @param Affiliation
     * @param PublicationYear
     * @param Keywords
     * @return
     */
    List<DocumentSummaryVO> selectDocumentSummaryByAll(@Param("AuthorName") String AuthorName,@Param("Affiliation") String Affiliation,
                                                       @Param("PublicationYear") String PublicationYear,@Param("Keywords") String Keywords);
    /**
     * 根据Doi信息查找电影
     * @param doi
     * @return
     */
    List<DocumentVO> selectDocumentByDoi(@Param("doi") String doi);

    List<DocumentVO> selectTopTenReference();

    Integer getDocumentCount(@Param("id") int affiliationId);

    Integer getDocumentCountByAuthorId(@Param("id") int authorId);

    Integer getDocumentCountByAffIdAndYear(@Param("id") int affiliationId, @Param("year") int year);

    Integer getDocumentCountByAuthorIdAndYear(@Param("id") int authorId, @Param("year") int year);

    Integer getRefCount(@Param("id") int affiliationId);

    List<String> selectByAffId(@Param("id") int affiliationId);

    DocumentSummaryVO selectByDoi(@Param("DOI") String Doi);

    List<DocumentSummaryVO> selectAllDocByAffId(@Param("id") int affiliationId);

    List<DocumentSummaryVO> selectAllDocByKeyword(@Param("keyword") String keyword);

    Integer getDocumentCountByYearAndKeyword(@Param("keyword") String keyword,@Param("year") int year);

}
