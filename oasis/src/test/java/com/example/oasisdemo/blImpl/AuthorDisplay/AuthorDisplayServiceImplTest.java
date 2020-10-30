package com.example.oasisdemo.blImpl.AuthorDisplay;

import com.example.oasisdemo.OasisdemoApplication;
import com.example.oasisdemo.data.AuthorDisplay.AuthorDisplayMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.mock;

@SpringBootTest(classes = OasisdemoApplication.class)
@Transactional
class AuthorDisplayServiceImplTest {
    @Autowired
    private AuthorDisplayMapper authorDisplayMapper;
    @Autowired
    private AuthorDisplayServiceImpl authorDisplayService;


}