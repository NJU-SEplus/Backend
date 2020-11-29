package com.example.oasisdemo.data.AuthorDisplay;

import com.example.oasisdemo.vo.*;
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

    List<AuthorInfoVO> selectAuthorByPubCnt();

    List<AuthorInfoVO> selectAuthorByHeat();

    String selectAuthorDirections(@Param("id") String id);

    List<CollaboratorVO> selectCollaboratorById(@Param("id") String id);

    String selectCitedPapersByDoi(@Param("doi") String doi);
}
