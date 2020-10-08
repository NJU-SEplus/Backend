package com.example.oasisdemo.data.AuthorDisplay;

import com.example.oasisdemo.OasisdemoApplication;
import com.example.oasisdemo.vo.AuthorPortraitVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OasisdemoApplication.class)
@Transactional
class AuthorDisplayMapperTest {
    @Autowired
    private AuthorDisplayMapper authorDisplayMapper;

    @Test
    void selectTopTenPublication() {
//        System.out.println(authorDisplayMapper.selectTopTenPublication().size());
        for(AuthorPortraitVO author:authorDisplayMapper.selectTopTenPublication()) {
            System.out.println(author.getAuthor_name());
        }
    }

    @Test
    void getAuthorCount() {
    }

    @Test
    void selectByAffId() {
    }

    @Test
    void testSelectTopTenPublication() {
    }

    @Test
    void selectAuthorById() {
        Assertions.assertEquals("Y. Liu",authorDisplayMapper.selectAuthorById(2).get(0).getAuthor_name());
    }

    @Test
    void selectAllAuthor() {
    }

    @Test
    void selectAuthorByName(){
    }

    @Test
    void getPaperCitation() {
        Assertions.assertEquals(5,authorDisplayMapper.getPaperCitation("Round-up: Runtime checking quasi linearizability of concurrent data structures"));
//        System.out.println(authorDisplayMapper.getPaperCitation("Round-up: Runtime checking quasi linearizability of concurrent data structures"));
    }
}