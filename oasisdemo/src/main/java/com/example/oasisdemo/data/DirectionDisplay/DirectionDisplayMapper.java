package com.example.oasisdemo.data.DirectionDisplay;


import com.example.oasisdemo.vo.SimpleResearchDirectionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DirectionDisplayMapper {

    List<SimpleResearchDirectionVO> selectAllDirection();

    List<SimpleResearchDirectionVO> selectDirectionByName(@Param("name") String directionName);

    SimpleResearchDirectionVO selectDirectionById(@Param("id") int id);

    List<SimpleResearchDirectionVO> selectDirectionByHeat();

}
