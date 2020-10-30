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
    public ResponseVO getAuthorInfoByName(String name) {
        try {
            PageHelper.startPage(1,10);
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
            List<AuthorInfoVO> res=authorDisplayMapper.selectAuthorByPubCnt(10);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

}
