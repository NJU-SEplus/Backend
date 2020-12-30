package com.example.oasisdemo.data.AuthorDisplay;

import com.example.oasisdemo.OasisdemoApplication;
import com.example.oasisdemo.vo.AuthorInfoVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootTest(classes = OasisdemoApplication.class)
@Transactional
class AuthorDisplayMapperTest {
    @Autowired
    private AuthorDisplayMapper authorDisplayMapper;

    @Test
    void testSelectAuthorPapersById() {
        Assertions.assertEquals("A Steiner tree approach to efficient object detection",authorDisplayMapper.selectAuthorPapersById("37419365800").get(0).getTitle());
    }

    @Test
    void testSelectAuthorTopicsById() {
        for(String str:Arrays.asList(authorDisplayMapper.selectAuthorTopicsById("37419365800").split("\n|;"))){
            System.out.println(str);
        }
    }

    @Test
    void testSelectAuthorInfoById() {
        Assertions.assertEquals("Andrew Y. Ng",authorDisplayMapper.selectAuthorInfoById("37419365800").getAuthor_name());
        Assertions.assertEquals(500,authorDisplayMapper.selectAuthorInfoById("37419365800").getCitation());
        Assertions.assertEquals(2,authorDisplayMapper.selectAuthorInfoById("37419365800").getAuthor_paperCount());
        Assertions.assertEquals("Stanford University;",authorDisplayMapper.selectAuthorInfoById("37419365800").getAffiliation().get(0));
    }

    @Test
    void testSelectAuthorInfoByName() {
        AuthorInfoVO author=authorDisplayMapper.selectAuthorInfoByName("Andrew Y. Ng").get(0);
        Assertions.assertEquals("Andrew Y. Ng",author.getAuthor_name());
        Assertions.assertEquals("37419365800",author.getAuthor_id());
        Assertions.assertEquals(2,author.getAuthor_paperCount());
    }

    @Test
    void selectAuthorDirections() {
        Assertions.assertEquals("%2010%Heart;Algorithm design and analysis;Computer science;%2011%Training;Convolution;Image edge detection;%2012%%2013%%2014%%2015%%2016%%2017%%2018%%2019%",authorDisplayMapper.selectAuthorDirections("37419365800"));
    }

}