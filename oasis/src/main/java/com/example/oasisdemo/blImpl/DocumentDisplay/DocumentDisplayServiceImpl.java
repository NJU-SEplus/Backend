package com.example.oasisdemo.blImpl.DocumentDisplay;

import com.example.oasisdemo.bl.DocumnetDisplay.DocumentDisplayService;
import com.example.oasisdemo.data.DocumentDisplay.DocumentDisplayMapper;
import com.example.oasisdemo.vo.DocumentSummaryVO;
import com.example.oasisdemo.vo.DocumentVO;
import com.example.oasisdemo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DocumentDisplayServiceImpl implements DocumentDisplayService {
    private static final String DOESNT_EXIST_MESSAGE="未找到相关内容";

    @Autowired
    DocumentDisplayMapper documentDisplayMapper;

    @Override
    public ResponseVO searchDocumentSummaryByTitle(String title){
        try {
            List<DocumentSummaryVO> res= documentDisplayMapper.selectDocumentSummaryVOByTitle(title);
//            System.out.println(res.get(0).getAffiliation());
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    };

    @Override
    public ResponseVO searchDocumentSummaryByAuthorName(String AuthorName){
        try {
            List<DocumentSummaryVO> res= documentDisplayMapper.selectDocumentSummaryVOByAuthorName(AuthorName);
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    };

    @Override
    public ResponseVO searchDocumentSummaryByPublicationYear(String PublicationYear){
        try {
            List<DocumentSummaryVO> res= documentDisplayMapper.selectDocumentSummaryVOByPublicationYear(PublicationYear);
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    };

    @Override
    public ResponseVO searchDocumentSummaryByAffiliationName(String AffiliationName){
        try {
            List<DocumentSummaryVO> res= documentDisplayMapper.selectDocumentSummaryVOByAffiliationName(AffiliationName);
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    };

    @Override
    public ResponseVO searchDocumentSummaryByKeyword(String Keyword) {
        try {
            String[] keywords=Keyword.split(" ");
            List<String> keywords1=new ArrayList<String>();
            Collections.addAll(keywords1, keywords);
            List<DocumentSummaryVO> finalres=new ArrayList<DocumentSummaryVO>();
            HashMap<DocumentSummaryVO,Integer> x=new HashMap();
            for(int i=0;i<keywords1.size();i++) {
                List<DocumentSummaryVO> res= documentDisplayMapper.selectDocumentSummaryVOByKeyword(keywords1.get(i));
                for(int j=0;j<res.size();j++){
                    if(x.containsKey(res.get(j))){
                        int num=x.get(res.get(j));
                        num++;
                        x.put(res.get(j),num);
                    }
                    else{
                        x.put(res.get(j),1);
                    }
                }
            }
            List<Map.Entry<DocumentSummaryVO, Integer>> list = new ArrayList<>();
            for(Map.Entry<DocumentSummaryVO, Integer> entry : x.entrySet()){
                list.add(entry); //将map中的元素放入list中
            }

            list.sort(new Comparator<Map.Entry<DocumentSummaryVO, Integer>>(){
                @Override
                public int compare(Map.Entry<DocumentSummaryVO, Integer> o1, Map.Entry<DocumentSummaryVO, Integer> o2) {
                    return o2.getValue()-o1.getValue();}
                //逆序（从大到小）排列，正序为“return o1.getValue()-o2.getValue”
            });
            List<DocumentSummaryVO> res=new ArrayList<>();
            for(Map.Entry<DocumentSummaryVO, Integer> entry: list){
                res.add(entry.getKey());
            }
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    };

    @Override
    public ResponseVO searchDocumentSummaryByDOI(String DOI){
        return ResponseVO.buildFailure("成功");
    };

    @Override
    public ResponseVO searchDocumentSummaryByAll(String AuthorName,String Affiliation,String Year,String Keywords){
        try {
            List<DocumentSummaryVO> res= documentDisplayMapper.selectDocumentSummaryByAll(AuthorName,Affiliation,Year,Keywords);
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    };

    @Override
    public ResponseVO searchDocumentByDoi(String doi){
        try {
            List<DocumentVO> res= documentDisplayMapper.selectDocumentByDoi(doi);
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    };
    @Override
    public ResponseVO searchTopTenReferenceDocument(){
        try {
            List<DocumentVO> res=documentDisplayMapper.selectTopTenReference();
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }
}
