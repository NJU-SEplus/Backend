package com.example.oasisdemo.blImpl.DocumentDisplay;

import com.example.oasisdemo.OasisdemoApplication;
import com.example.oasisdemo.bl.DocumnetDisplay.DocumentDisplayService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OasisdemoApplication.class)
@Transactional
class DocumentDisplayServiceImplTest {
    @Autowired
    private DocumentDisplayService documentDisplayService;

    @Test
    void searchDocumentSummaryByTitle() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentSummaryByTitle("BOOM: Experiences in language and tool design for distributed systems (keynote)").getSuccess());
    }

    @Test
    void searchDocumentSummaryByAuthorName() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentSummaryByAuthorName("J. M. Hellerstein").getSuccess());
    }

    @Test
    void searchDocumentSummaryByPublicationYear() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentSummaryByPublicationYear("2013").getSuccess());
    }

    @Test
    void searchDocumentSummaryByAffiliationName() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentSummaryByAffiliationName("University of California at Berkeley, USA").getSuccess());
    }

    @Test
    void searchDocumentSummaryByKeyword() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentSummaryByKeyword("Abstraction,Refinement,SMT,Message Passing").getSuccess());
    }

    @Test
    void searchDocumentSummaryByAll() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentSummaryByAll("J. M. Hellerstein",
                "%","2013","%").getSuccess());
    }

    @Test
    void searchDocumentByDoi() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentByDoi("10.1109/ASE.2013.6693058").getSuccess());
    }
}