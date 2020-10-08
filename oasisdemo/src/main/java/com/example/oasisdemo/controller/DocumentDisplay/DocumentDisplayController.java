package com.example.oasisdemo.controller.DocumentDisplay;

import com.example.oasisdemo.bl.DocumnetDisplay.DocumentDisplayService;
import com.example.oasisdemo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentDisplayController {
    @Autowired
    private DocumentDisplayService documentDisplayService;

    @RequestMapping(value = "/document/title/{title}", method = RequestMethod.GET)
    public ResponseVO searchDocumentSummaryByTitle(@PathVariable String title){
        return documentDisplayService.searchDocumentSummaryByTitle(title);
    }
    @RequestMapping(value = "/document/Author/{AuthorName}", method = RequestMethod.GET)
    public ResponseVO searchDocumentSummaryByAuthorName(@PathVariable String AuthorName){
        return documentDisplayService.searchDocumentSummaryByAuthorName(AuthorName);
    }
    @RequestMapping(value = "/document/PublicationYear/{PublicationYear}", method = RequestMethod.GET)
    public ResponseVO searchDocumentSummaryByPublicationYear(@PathVariable String PublicationYear){
        return documentDisplayService.searchDocumentSummaryByPublicationYear(PublicationYear);
    }
    @RequestMapping(value = "/document/Institution/{AffiliationName}", method = RequestMethod.GET)
    public ResponseVO searchDocumentSummaryByAffiliationName(@PathVariable String AffiliationName){
        return documentDisplayService.searchDocumentSummaryByAffiliationName(AffiliationName);
    }
    @RequestMapping(value = "/document/Keywords/{Keyword}", method = RequestMethod.GET)
    public ResponseVO searchDocumentSummaryByKeyword(@PathVariable String Keyword){
        return documentDisplayService.searchDocumentSummaryByKeyword(Keyword);
    }
    @RequestMapping(value = "/document/complex")
    public ResponseVO searchDocumentSummaryByAll(@RequestParam("authorname") String authorname, @RequestParam ("affiliation")String affiliation,
                                                 @RequestParam("year") String year, @RequestParam("keywords") String keywords){
        return documentDisplayService.searchDocumentSummaryByAll(authorname,affiliation,year,keywords);
    }
    @RequestMapping(value = "/document/DOI", method = RequestMethod.GET)
    public ResponseVO searchDocumentByDoi(@RequestParam("doi") String doi){
        return documentDisplayService.searchDocumentByDoi(doi);
    }
    @RequestMapping(value = "/browse/TopTenReferenceDocuments", method = RequestMethod.GET)
    public ResponseVO searchTopTenReferenceDocument(){
        return documentDisplayService.searchTopTenReferenceDocument();
    }
}
