package com.example.oasisdemo.blImpl.AffiliationDisplay;

import com.example.oasisdemo.OasisdemoApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OasisdemoApplication.class)
@Transactional
class AffiliationDisplayServiceImplTest {
    @Autowired
    private AffiliationDisplayServiceImpl affiliationDisplayService;

    @Test
    void getAffiliationPortrait() {
        Assertions.assertEquals(true,affiliationDisplayService.getAffiliationPortrait(0).getSuccess());
    }

    @Test
    void showAllAffiliation() {
        Assertions.assertEquals(true,affiliationDisplayService.showAllAffiliation().getSuccess());
    }

    @Test
    void getAffiliationByName() {
        Assertions.assertEquals(true,affiliationDisplayService.getAffiliationByName("Nanjing University").getSuccess());
    }

    @Test
    void showAffiliationByCountry() {
        Assertions.assertEquals(true,affiliationDisplayService.showAffiliationByCountry().getSuccess());
    }

    @Test
    void showAffiliationByHeat() {
        Assertions.assertEquals(true,affiliationDisplayService.showAffiliationByHeat().getSuccess());
    }
}