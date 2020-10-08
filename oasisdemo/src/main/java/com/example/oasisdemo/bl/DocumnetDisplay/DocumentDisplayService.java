package com.example.oasisdemo.bl.DocumnetDisplay;


import com.example.oasisdemo.vo.ResponseVO;


public interface DocumentDisplayService {
    /**
     * 根据文章名搜索文章，title可能不为全名，返回一个List<DocumentSummaryVO>对象
     * @param title
     * @return
     */
    ResponseVO searchDocumentSummaryByTitle(String title);
    /**
     * 根据作者名搜索文章，返回一个List<DocumentSummaryVO>对象
     * @param AuthorName
     * @return
     */
    ResponseVO searchDocumentSummaryByAuthorName(String AuthorName);
    /**
     * 根据年份搜索文章，返回一个List<DocumentSummaryVO>对象
     * @param PublicationYear
     * @return
     */
    ResponseVO searchDocumentSummaryByPublicationYear(String PublicationYear);
    /**
     * 根据机构名搜索文章，返回一个List<DocumentSummaryVO>对象
     * @param AffiliationName
     * @return
     */
    ResponseVO searchDocumentSummaryByAffiliationName(String AffiliationName);
    /**
     * 根据关键词搜索文章，返回一个List<DocumentSummaryVO>对象
     * @param Keyword
     * @return
     */
    ResponseVO searchDocumentSummaryByKeyword(String Keyword);
    /**
     * 根据DOI搜索文章，返回一个DocumentVO对象
     * @param DOI
     * @return
     */
    ResponseVO searchDocumentSummaryByDOI(String DOI);
    /**
     * 根据表单搜索文章，返回一个DocumentSummaryVO对象
     * @param AuthorName
     * @param Affiliation
     * @param Year
     * @param Keywords
     * @return
     */
    ResponseVO searchDocumentSummaryByAll(String AuthorName,String Affiliation,String Year,String Keywords);
    /**
     * 根据doi搜索文章详细信息，返回一个DocumentVO对象
     * @param doi
     * @return
     */
    ResponseVO searchDocumentByDoi(String doi);
    /**
     * 查询引用量前十的论文，返回一个List<DocumentSummaryVO>对象
     * @return
     */
    ResponseVO searchTopTenReferenceDocument();
}
