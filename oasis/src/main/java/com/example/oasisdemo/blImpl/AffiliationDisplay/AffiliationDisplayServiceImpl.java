package com.example.oasisdemo.blImpl.AffiliationDisplay;

import com.example.oasisdemo.bl.AffiliationDisplay.AffiliationDisplayService;
import com.example.oasisdemo.data.AffiliationDisplay.AffiliationDisplayMapper;
import com.example.oasisdemo.data.AuthorDisplay.AuthorDisplayMapper;
import com.example.oasisdemo.data.DocumentDisplay.DocumentDisplayMapper;
import com.example.oasisdemo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map.Entry;

@Service
public class AffiliationDisplayServiceImpl implements AffiliationDisplayService {
    private static final String DOESNT_EXIST_MESSAGE="未找到相关内容";

    @Autowired
    AffiliationDisplayMapper affiliationDisplayMapper;
    @Autowired
    AuthorDisplayMapper authorDisplayMapper;
    @Autowired
    DocumentDisplayMapper documentDisplayMapper;
    @Override
    public ResponseVO getAffiliationPortrait(int id){
        try {
            int heat=0;
            AffiliationVO affiliationVO=new AffiliationVO();
            SimpleAffiliationVO simpleAffiliationVO=affiliationDisplayMapper.selectAffiliationById(id);
            affiliationVO.setId(simpleAffiliationVO.getAffiliation_id());
            affiliationVO.setName(simpleAffiliationVO.getAffiliation_name());
            affiliationVO.setAuthorCount(authorDisplayMapper.getAuthorCount(id));
            affiliationVO.setDocuCount(documentDisplayMapper.getDocumentCount(id));
            if(documentDisplayMapper.getRefCount(id)==null)
                affiliationVO.setRefCount(0);
            else
                affiliationVO.setRefCount(documentDisplayMapper.getRefCount(id));
            List<Integer> docByYear=new ArrayList<Integer>();
            for(int i=2012;i<2020;i++){
                docByYear.add(documentDisplayMapper.getDocumentCountByAffIdAndYear(id,i));
            }
            affiliationVO.setHeat(simpleAffiliationVO.getHeat());
            affiliationVO.setDocuCountByYear(docByYear);
            affiliationVO.setAuthorOfAffiliation(authorDisplayMapper.selectByAffId(id));
            List<String> doi=documentDisplayMapper.selectByAffId(id);
            List<DocumentSummaryVO> doc=new ArrayList<>();
            for(int i=0;i<doi.size();i++)
                doc.add(documentDisplayMapper.selectByDoi(doi.get(i)));
            affiliationVO.setMostRefDocu(doc);
            affiliationVO.setKeyWord(getKeyWord(id));
            return ResponseVO.buildSuccess(affiliationVO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }
    @Override
    public ResponseVO showAllAffiliation(){
        try {
            List<SimpleAffiliationVO> res=affiliationDisplayMapper.selectAllAffiliation();
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }
    @Override
    public ResponseVO getAffiliationByName(String name){
        try {
            List<SimpleAffiliationVO> res=affiliationDisplayMapper.selectAffiliationByName(name);
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showAffiliationByCountry(){
        try {
            List<SimpleAffiliationVO> aff=affiliationDisplayMapper.selectAllAffiliation();
            if(aff.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            HashMap<String,Integer> res=new HashMap<>();
            for(int i=0;i<aff.size();i++){
                Set<String> wordSet=res.keySet();
                String country=aff.get(i).getCountry();
                //如果已经有这个单词了，
                if(wordSet.contains(country))
                {
                    Integer number=res.get(country);
                    number++;
                    res.put(country, number);
                }
                else {
                    res.put(country, 1);
                }
            }
            List<HashMap.Entry<String, Integer>> list = new ArrayList<HashMap.Entry<String, Integer>>(res.entrySet());
            Collections.sort(list, new Comparator<HashMap.Entry<String, Integer>>() {
                //降序排序
                @Override
                public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            StringBuilder resStr=new StringBuilder("{");
            for (HashMap.Entry<String, Integer> mapping : list) {
                resStr.append(mapping.getKey()).append(",").append(mapping.getValue()).append(";");
            }
            return ResponseVO.buildSuccess(resStr.append("}").toString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败！");
        }
    }

    @Override
    public ResponseVO showAffiliationByHeat(){
        try {
            List<SimpleAffiliationVO> res=affiliationDisplayMapper.selectAffiliationByHeat();

//            PriorityQueue<Integer> heatList=new PriorityQueue<>();
//            int listSize=0;
//            List<AffiliationVO> topAff=new ArrayList<>();
//            for(int i=0;i<res.size();i++){
//                topAff.add((AffiliationVO)getAffiliationPortrait(res.get(i).getAffiliation_id()).getContent());
//            }
//            for(int i=0;i<res.size();i++){
//                int heat=0;
//                int id=res.get(i).getAffiliation_id();
//                List<Integer> docByYear=new ArrayList<Integer>();
//                for(int j=2012;j<2020;j++){
//                    docByYear.add(documentDisplayMapper.getDocumentCountByAffIdAndYear(id,j));
//                    heat+=documentDisplayMapper.getDocumentCountByAffIdAndYear(id,j)*(j-2000);
//                }
//                heat+=documentDisplayMapper.getDocumentCount(id);
//                heat+=authorDisplayMapper.getAuthorCount(id);
//                affiliationDisplayMapper.updateHeat(id,heat);
//                if(listSize<100){
//                        heatList.add(heat);
//                        topAff.add((AffiliationVO)getAffiliationPortrait(id).getContent());
//                        listSize++;
//                    }
//                else {
//                        if(heat>heatList.peek()){
//                            int lowerHeat=heatList.peek();
//                            for(int k=0;k<topAff.size();k++){
//                                if(topAff.get(k).getHeat()==lowerHeat) {
//                                    topAff.remove(k);
//                                    break;
//                                }
//                            }
//                            System.out.println();
//                            heatList.poll();
//                            heatList.add(heat);
//                            topAff.add((AffiliationVO)getAffiliationPortrait(id).getContent());
//                        }
//                }
//            }
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showRelationByName(String affiliationName){
        try {
            List<RelationVO> res=affiliationDisplayMapper.selectRelationByName(affiliationName);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    private String getKeyWord(int id){
        StringBuilder stringBuilder=new StringBuilder();
        List<DocumentSummaryVO> documents=documentDisplayMapper.selectAllDocByAffId(id);
        HashMap<String,Integer> res=new HashMap<>();
        HashMap<String,Integer> res1=new HashMap<>();
        String s="";
        for (int i=0;i<documents.size();i++){
            DocumentVO documentVo=documentDisplayMapper.selectDocumentByDoi(documents.get(i).getDOI()).get(0);
            int ref=documentVo.getReferenceCount()+1;
            stringBuilder.append(documents.get(i).getIEEEterm());
            s=stringBuilder.toString();
            String[] tmp=s.split(",");
            Set<String> wordSet=res.keySet();
            for(int j=0;j<tmp.length;j++) {
                //如果已经有这个单词了，
                if(wordSet.contains(tmp[j]))
                {
                    Integer number=res.get(tmp[j]);
                    Integer tmpref=res1.get(tmp[j]);
                    tmpref+=ref;
                    res1.put(tmp[j],tmpref);
                    number++;
                    res.put(tmp[j], number);

                }
                else
                {
                    res1.put(tmp[j],ref);
                    res.put(tmp[j], 1);
                }
            }
        }
        List<Integer> a=new ArrayList<Integer>(res1.values());

        List<HashMap.Entry<String, Integer>> list = new ArrayList<HashMap.Entry<String, Integer>>(res.entrySet());
        Collections.sort(list, new Comparator<HashMap.Entry<String, Integer>>() {
            //降序排序
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int flag=0;
        StringBuilder resStr=new StringBuilder("{");
        for (HashMap.Entry<String, Integer> mapping : list) {
            resStr.append(mapping.getKey()).append(",").append(mapping.getValue()*a.get(flag)).append(";");
            flag++;
        }
        return resStr.append("}").toString();
    }


}
