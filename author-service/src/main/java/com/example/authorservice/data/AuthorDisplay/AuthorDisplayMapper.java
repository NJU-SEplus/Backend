package com.example.authorservice.data.AuthorDisplay;

import com.example.authorservice.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface AuthorDisplayMapper {

    List<PaperVO> selectAuthorPapersById(@Param("id") String id);

    String selectAuthorTopicsById(@Param("id") String id);

    AuthorInfoVO selectAuthorInfoById(@Param("id") String id);

    List<AuthorInfoVO> selectAuthorInfoByName(@Param("name") String name);
}
