package com.example.oasisdemo.blImpl.AuthorDisplay;
import com.example.oasisdemo.bl.AuthorDisplay.AuthorDisplayService;
import com.example.oasisdemo.data.AuthorDisplay.AuthorDisplayMapper;
import com.example.oasisdemo.data.DocumentDisplay.DocumentDisplayMapper;
import com.example.oasisdemo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map.Entry;


@Service
public class AuthorDisplayServiceImpl implements  AuthorDisplayService{
    private static final String DOESNT_EXIST_MESSAGE="未找到相关内容";

    @Autowired
    AuthorDisplayMapper authorDisplayMapper;
    @Autowired
    DocumentDisplayMapper documentDisplayMapper;

    @Override
    public ResponseVO searchTopTenPublicationAuthor(){
        try {
            List<AuthorPortraitVO> res=authorDisplayMapper.selectTopTenPublication();
//            System.out.println(res.size());
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO searchAuthorPortraitById(int id){
        try {
            List<AuthorPortraitVO> res= authorDisplayMapper.selectAuthorById(id);
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }

    }
    @Override
    public ResponseVO searchAllAuthor(){
        try {
            List<AuthorPortraitVO> res= authorDisplayMapper.selectAllAuthor();
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }

    }
    @Override
    public ResponseVO searchAuthorByName(String name){
        try {
            List<AuthorPortraitVO> res= authorDisplayMapper.selectAuthorByName(name);
            if(res.size()==0)
                return ResponseVO.buildFailure(DOESNT_EXIST_MESSAGE);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败!");
        }

    }

    @Override
    public ResponseVO getAuthorHindexById(int id){
        try {
            AuthorPortraitVO author = authorDisplayMapper.selectAuthorById(id).get(0);
            return ResponseVO.buildSuccess(calculateHindex(author.getPaperTitles()));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO getAuthorPartnersById(int id) {
        try {
            AuthorPortraitVO author = authorDisplayMapper.selectAuthorById(id).get(0);
            return ResponseVO.buildSuccess(getAuthorPartners(author.getAuthor_name(),author.getPaperTitles()));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showRelationByAuthorId(int id){
        try {
            List<RelationVO> res=authorDisplayMapper.selectRelationById(id);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showABRelation(int Aid,int Bid){
        try{
            List<RelationVO> res=authorDisplayMapper.selectABRelation(Aid,Bid);
            if(res.size()==0) {
                List<RelationVO> ARelations=authorDisplayMapper.selectRelationById(Aid);
                List<RelationVO> BRelations=authorDisplayMapper.selectRelationById(Bid);
                for (RelationVO ARelation:ARelations){
                    for (RelationVO BRelation:BRelations){
                        if(ARelation.getA_id()==BRelation.getA_id()||ARelation.getA_id()==BRelation.getB_id()||
                                ARelation.getB_id()==BRelation.getA_id()||ARelation.getB_id()==BRelation.getB_id()){
                            res.add(ARelation);
                            res.add(BRelation);
                        }
                    }
                }
            }
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    @Override
    public ResponseVO showAuthorByHeat(){
        try {
            List<AuthorPortraitVO> res=authorDisplayMapper.selectAuthorByHeat();

//            PriorityQueue<Integer> heatList=new PriorityQueue<>();
//            int listSize=0;
//            List<AuthorPortraitVO> topAff=new ArrayList<>();
//            for(int i=0;i<res.size();i++){
//                topAff.add(authorDisplayMapper.selectAuthorById(res.get(i).getAuthor_id()).get(0));
//            }
//            for(int i=0;i<res.size();i++){
//                int heat=0;
//                int id=res.get(i).getAuthor_id();
//                List<Integer> docByYear=new ArrayList<Integer>();
//                for(int j=2012;j<2020;j++){
//                    docByYear.add(documentDisplayMapper.getDocumentCountByAuthorIdAndYear(id,j));
//                    System.out.print(id+"         ");
//                    System.out.println(documentDisplayMapper.getDocumentCountByAuthorIdAndYear(id,j));
//                    heat+=documentDisplayMapper.getDocumentCountByAuthorIdAndYear(id,j)*(j-2000);
//                }
//                heat+=documentDisplayMapper.getDocumentCountByAuthorId(id);
//                authorDisplayMapper.updateHeat(id,heat);
//                if(listSize<100){
//                        heatList.add(heat);
//                        topAff.add(authorDisplayMapper.selectAuthorById(res.get(i).getAuthor_id()).get(0));
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
//                            topAff.add(authorDisplayMapper.selectAuthorById(res.get(i).getAuthor_id()).get(0));
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
            List<String> res=Arrays.asList(str.split("\n|;"));
            return ResponseVO.buildSuccess(res);
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
            List<AuthorInfoVO> res=authorDisplayMapper.selectAuthorInfoByName(name);
            return ResponseVO.buildSuccess(res);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    public HashMap<String,Integer> getAuthorPartners(String author_name, List<String> paperTitles) {
        String s="";
        for (String paper:paperTitles){
            s+=",";
            s+=authorDisplayMapper.getPaperAuthors(paper);
        }
        String[] partnerCounts=s.split(",");
        HashMap<String,Integer> partners=new HashMap<>();
        for(String partner:partnerCounts){
            if(partner.equals(author_name))
                continue;
            if(partners.containsKey(partner))
                partners.put(partner,partners.get(partner)+1);
            else
                partners.put(partner,1);
        }
        return partners;
    }

    public Integer calculateHindex(List<String> PaperTitles) {
        int n=PaperTitles.size();
//        System.out.println(authorDisplayMapper.selectAuthorById(12).get(0).getAuthor_name());
        int[] citations=new int[n];
        for (int i=0;i<n;i++) {
            citations[i] = authorDisplayMapper.getPaperCitation(PaperTitles.get(i));
//            System.out.println(PaperTitles.get(i));
        }
        int[] arrCount = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) arrCount[n]++;
            else arrCount[citations[i]]++;
        }
        for (int i = n; i > 0; i--) {
            if (arrCount[i] >= i) return i;
            arrCount[i - 1] += arrCount[i];
        }
        return 0;
    }
}
