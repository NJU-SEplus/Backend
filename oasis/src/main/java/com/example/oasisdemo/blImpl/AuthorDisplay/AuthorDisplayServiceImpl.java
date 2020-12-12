package com.example.oasisdemo.blImpl.AuthorDisplay;
import com.example.oasisdemo.bl.AuthorDisplay.AuthorDisplayService;
import com.example.oasisdemo.data.AuthorDisplay.AuthorDisplayMapper;
import com.example.oasisdemo.po.Author;
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

    @Override
    public ResponseVO reviewerRecommended(RecommondParamVO recommondParamVO){
        try{
            List<String> keyword=recommondParamVO.getKeyword();
            HashMap<String,AuthorInfoVO> id2reviewers=new HashMap<>();
            List<AuthorInfoVO> tempReviewers=new ArrayList<AuthorInfoVO>();
            for (String key: keyword) {
                tempReviewers=authorDisplayMapper.selectAuthorInfoByKeyword(key);
                for (AuthorInfoVO reviewer:tempReviewers) {
                    if(!id2reviewers.containsKey(reviewer.getAuthor_id())){
                        id2reviewers.put(reviewer.getAuthor_id(),reviewer);
                    }
                }
            }
            if(recommondParamVO.getAuthorID()!=null){
                List<CollaboratorVO> Coll=authorDisplayMapper.selectCollaboratorById(recommondParamVO.getAuthorID());
                for (CollaboratorVO collaborator:
                     Coll) {
                    id2reviewers.remove(collaborator.getColla_id());
                }
            }
            ArrayList<AuthorInfoVO> revlist=new ArrayList<>(id2reviewers.values());
            ArrayList<String> aff=new ArrayList<>(recommondParamVO.getAffiliationName());
            for (String name:
                 aff) {
                for (AuthorInfoVO rev :
                        revlist) {
                    if (rev.getAffiliation().contains(name))
                        id2reviewers.remove(rev.getAuthor_id());
                }
            }
            revlist=new ArrayList<>(id2reviewers.values());
            ArrayList<AuthorInfoVO> res=new ArrayList<>();
            for(int i=0;i<5;i++){
                res.add(revlist.get((int)(Math.random()*revlist.size())));
            }
            return ResponseVO.buildSuccess(res);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }
    public static float getSimilarityRatio(String str, String target) {

        int d[][]; // 矩阵
        int n = str.length();
        int m = target.length();
        int i; // 遍历str的
        int j; // 遍历target的
        char ch1; // str的
        char ch2; // target的
        int temp; // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
        if (n == 0 || m == 0) {
            return 0;
        }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++) { // 初始化第一列
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++) { // 初始化第一行
            d[0][j] = j;
        }

        for (i = 1; i <= n; i++) { // 遍历str
            ch1 = str.charAt(i - 1);
            // 去匹配target
            for (j = 1; j <= m; j++) {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2 || ch1 == ch2 + 32 || ch1 + 32 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                // 左边+1,上边+1, 左上角+temp取最小
                d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), d[i - 1][j - 1] + temp);
            }
        }

        return (1 - (float) d[n][m] / Math.max(str.length(), target.length())) * 100F;
    }

}
