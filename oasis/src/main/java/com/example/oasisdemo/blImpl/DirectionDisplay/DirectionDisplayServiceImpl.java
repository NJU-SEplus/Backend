package com.example.oasisdemo.blImpl.DirectionDisplay;

import com.example.oasisdemo.bl.DirectionDisplay.DirectionDisplayService;
import com.example.oasisdemo.data.AuthorDisplay.AuthorDisplayMapper;
import com.example.oasisdemo.data.DirectionDisplay.DirectionDisplayMapper;
import com.example.oasisdemo.data.DocumentDisplay.DocumentDisplayMapper;
import com.example.oasisdemo.vo.ResearchDirectionVO;
import com.example.oasisdemo.vo.ResponseVO;
import com.example.oasisdemo.vo.SimpleResearchDirectionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectionDisplayServiceImpl implements DirectionDisplayService {
    private static final String DOESNT_EXIST_MESSAGE="未找到相关内容";
    @Autowired
    private DirectionDisplayMapper directionDisplayMapper;
    @Autowired
    AuthorDisplayMapper authorDisplayMapper;
    @Autowired
    DocumentDisplayMapper documentDisplayMapper;
    @Override
    public ResponseVO getDirectionPortrait(int id){
        try {
            ResearchDirectionVO researchDirectionVO=new ResearchDirectionVO();
            SimpleResearchDirectionVO simpleResearchDirectionVO=directionDisplayMapper.selectDirectionById(id);
            researchDirectionVO.setId(simpleResearchDirectionVO.getId());
            researchDirectionVO.setName(simpleResearchDirectionVO.getName());
            researchDirectionVO.setAuthorCount(simpleResearchDirectionVO.getAuthorCount());
            researchDirectionVO.setDocuCount(simpleResearchDirectionVO.getDocCount());
            researchDirectionVO.setAffCount(simpleResearchDirectionVO.getAffCount());
            List<Integer> docByYear=new ArrayList<Integer>();
            for(int i=2012;i<2020;i++){
                docByYear.add(documentDisplayMapper.getDocumentCountByYearAndKeyword(simpleResearchDirectionVO.getName(),i));
            }
            researchDirectionVO.setDocuCountByYear(docByYear);
            researchDirectionVO.setAuthorOfDirection(authorDisplayMapper.selectByAuthorKeyword(simpleResearchDirectionVO.getName()));
            researchDirectionVO.setDocuOfDirection(documentDisplayMapper.selectAllDocByKeyword(simpleResearchDirectionVO.getName()));
            return ResponseVO.buildSuccess(researchDirectionVO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getDirectionByName(String name){
        try {
            List<SimpleResearchDirectionVO> res=directionDisplayMapper.selectDirectionByName(name);
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showAllDirection(){
        try {
            List<SimpleResearchDirectionVO> res=directionDisplayMapper.selectAllDirection();
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showDirectionByHeat(){
        try {
            List<SimpleResearchDirectionVO> res=directionDisplayMapper.selectDirectionByHeat();
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }
}
