package com.example.authorservice.AuthorDisplay;

import com.example.authorservice.AuthorServiceApplication;
import com.example.authorservice.data.AuthorDisplay.AuthorDisplayMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootTest(classes = AuthorServiceApplication.class)
@Transactional
class AuthorDisplayMapperTest {
    @Autowired
    private AuthorDisplayMapper authorDisplayMapper;

    @Test
    void selectAuthorPapersById(){
        Assertions.assertEquals("A Steiner tree approach to efficient object detection",authorDisplayMapper.selectAuthorPapersById("37419365800").get(0).getTitle());
    }

    @Test
    void selectAuthorTopicsById(){
        for(String str:Arrays.asList(authorDisplayMapper.selectAuthorTopicsById("37419365800").split("\n|;"))){
            System.out.println(str);
        }

    }

    @Test
    void selectAuthorInfoById(){
        Assertions.assertEquals("Andrew Y. Ng",authorDisplayMapper.selectAuthorInfoById("37419365800").getAuthor_name());
        Assertions.assertEquals(500,authorDisplayMapper.selectAuthorInfoById("37419365800").getCitation());
        Assertions.assertEquals(2,authorDisplayMapper.selectAuthorInfoById("37419365800").getAuthor_paperCount());
        Assertions.assertEquals("Stanford University;\n",authorDisplayMapper.selectAuthorInfoById("37419365800").getAffiliation().get(0));
    }

    @Test
    void selectAuthorInfoByName(){
        Assertions.assertEquals(638,authorDisplayMapper.selectAuthorInfoByName("Zhang").size());
    }
}