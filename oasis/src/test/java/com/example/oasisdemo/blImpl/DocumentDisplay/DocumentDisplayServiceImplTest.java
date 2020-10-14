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
        Assertions.assertEquals(true,documentDisplayService.searchDocumentSummaryByTitle("3D Scene priors for road detection").getSuccess());
    }

    @Test
    void searchDocumentSummaryByAuthorName() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentSummaryByAuthorName("Jose M. Alvarez").getSuccess());
    }

    @Test
    void searchDocumentSummaryByPublicationYear() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentSummaryByPublicationYear("2013").getSuccess());
    }

    @Test
    void searchDocumentSummaryByAffiliationName() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentSummaryByAffiliationName("Nanyang Technological University").getSuccess());
    }

    @Test
    void searchDocumentSummaryByAll() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentSummaryByAll("John D. Bustard",
                "%","2010","%").getSuccess());
    }

    @Test
    void searchDocumentByDoi() {
        Assertions.assertEquals(true,documentDisplayService.searchDocumentByDoi("10.1109/CVPR.2010.5540228").getSuccess());
    }
}