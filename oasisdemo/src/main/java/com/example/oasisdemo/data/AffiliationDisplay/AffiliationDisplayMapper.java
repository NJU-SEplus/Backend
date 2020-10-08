package com.example.oasisdemo.data.AffiliationDisplay;
import com.example.oasisdemo.vo.SimpleAffiliationVO;
import com.example.oasisdemo.vo.RelationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Mapper
@Repository
public interface AffiliationDisplayMapper {
    /**
     * 展示全部机构
     * @param
     * @return List<SimpleAffiliationVO>
     */
    List<SimpleAffiliationVO> selectAllAffiliation();
    /**
     * 根据名称或关键字查找机构
     * @param  affiliationName
     * @return List<SimpleAffiliationVO>
     */
    List<SimpleAffiliationVO> selectAffiliationByName(@Param("name") String affiliationName);
    /**
     * 根据id查找机构
     * @param  id
     * @return List<SimpleAffiliationVO>
     */
    SimpleAffiliationVO selectAffiliationById(@Param("id") int id);

    int updateHeat(@Param("id") int id,@Param("heat") int heat);

    List<SimpleAffiliationVO> selectAffiliationByHeat();

    List<RelationVO> selectRelationByName(@Param("name") String affiliationName);


}
