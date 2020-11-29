package com.example.oasisdemo.blImpl.AuthorDisplay;
import com.example.oasisdemo.bl.AuthorDisplay.AuthorDisplayService;
import com.example.oasisdemo.data.AuthorDisplay.AuthorDisplayMapper;
import com.example.oasisdemo.vo.*;
import com.github.pagehelper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map.Entry;


@Service
public class AuthorDisplayServiceImpl implements  AuthorDisplayService{
    private static final String DOESNT_EXIST_MESSAGE="未找到相关内容";

    @Autowired
    AuthorDisplayMapper authorDisplayMapper;

    @Override
    public ResponseVO getAuthorPapersById(String id) {
        try {
            List<PaperVO> res=authorDisplayMapper.selectAuthorPapersById(id);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getAuthorTopicsById(String id) {
        try {
            String str=authorDisplayMapper.selectAuthorTopicsById(id);
            List<String> aff=Arrays.asList(str.split("\n|;"));
            HashMap<String,Integer> res=new HashMap<>();
            for(int i=0;i<aff.size();i++){
                Set<String> wordSet=res.keySet();
                String topic=aff.get(i);
                //如果已经有这个单词了，
                if(topic.equals("\r")||topic.equals("NA")){
                    continue;
                }
                if(wordSet.contains(topic))
                {
                    Integer number=res.get(topic);
                    number++;
                    res.put(topic, number);
                }
                else {
                    res.put(topic, 1);
                }
            }
            List<HashMap.Entry<String, Integer>> list = new ArrayList<HashMap.Entry<String, Integer>>(res.entrySet());
            Collections.sort(list, new Comparator<HashMap.Entry<String, Integer>>() {
                //降序排序
                @Override
                public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
//            StringBuilder resStr=new StringBuilder("{");
//            for (HashMap.Entry<String, Integer> mapping : list) {
//                resStr.append(mapping.getKey()).append(",").append(mapping.getValue()).append(";");
//            }
            return ResponseVO.buildSuccess(list);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getAuthorInfoById(String id) {
        try {
            AuthorInfoVO res=authorDisplayMapper.selectAuthorInfoById(id);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getAuthorInfoByName(String name,int pageNum,int pageSize) {
        try {
            PageHelper.startPage(pageNum,pageSize);
            PageInfo<AuthorInfoVO> res  = new PageInfo<AuthorInfoVO>(authorDisplayMapper.selectAuthorInfoByName(name));
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showAuthorByPubCnt() {
        try {
            List<AuthorInfoVO> res=authorDisplayMapper.selectAuthorByPubCnt();
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showAuthorByHeat() {
        try {
            List<AuthorInfoVO> res=authorDisplayMapper.selectAuthorByHeat();
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showResearchDirectionById(String id) {
        try {
            String keyword=authorDisplayMapper.selectAuthorDirections(id);
            List<ResearchDirectionVO> list=new ArrayList<ResearchDirectionVO>();
            String[] splits=keyword.split("%");
            //HashMap<String,String> res=new HashMap<>();
            for(int i=1;i<splits.length;i+=2){
                ResearchDirectionVO rd=new ResearchDirectionVO();
                if(i==splits.length-1) {
                    rd.setYear(splits[i]);
                    String[] s={""};
                    rd.setDirection(s);
                }
                else{
                    rd.setYear(splits[i]);
                    rd.setDirection(splits[i+1].split(";"));
                }
                list.add(rd);
            }
            return ResponseVO.buildSuccess(list);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showCollaboratorsById(String id) {
        try {
            List<CollaboratorVO> res=authorDisplayMapper.selectCollaboratorById(id);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showCitedPapersByDoi(String doi) {
        try {
            String references=authorDisplayMapper.selectCitedPapersByDoi(doi);
            List<CitedPaperVO> res=new ArrayList<>();
            String temp[]=references.split("%");
            int i=1;
            while(2*i<temp.length){
                res.add(new CitedPaperVO(temp[2*i],temp[2*(i+1)],temp[2*(i+2)].substring(0,temp[2*(i+2)].length()-2)));
                i+=3;
            }
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

}
