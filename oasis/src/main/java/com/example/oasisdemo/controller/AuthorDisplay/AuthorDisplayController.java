package com.example.oasisdemo.controller.AuthorDisplay;

import com.example.oasisdemo.bl.AuthorDisplay.AuthorDisplayService;
import com.example.oasisdemo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://101.132.151.29","http://120.55.43.25:8088/"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, maxAge = 60L)
@RestController
public class AuthorDisplayController {
    @Autowired
    private AuthorDisplayService authorDisplayService;

    @RequestMapping(value = "/author/papers",method = RequestMethod.GET )
    public ResponseVO getAuthorPapersById(@RequestParam("id") String id){
        return authorDisplayService.getAuthorPapersById(id);
    }

    @RequestMapping(value = "/author/topics",method = RequestMethod.GET )
    public ResponseVO getAuthorTopicsById(@RequestParam("id") String id){
        return authorDisplayService.getAuthorTopicsById(id);
    }

    @RequestMapping(value = "/author/basicinfo",method = RequestMethod.GET )
    public ResponseVO getAuthorInfoById(@RequestParam("id") String id){
        return authorDisplayService.getAuthorInfoById(id);
    }

    @RequestMapping(value = "/search/name",method = RequestMethod.GET )
    public ResponseVO getAuthorInfoByName(@RequestParam("name") String name,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        return authorDisplayService.getAuthorInfoByName(name,pageNum,pageSize);
    }

    @RequestMapping(value = "/author/showByPublishCount",method = RequestMethod.GET )
    public ResponseVO showAuthorInfoByPubCnt(){
        return authorDisplayService.showAuthorByPubCnt();
    }

    @RequestMapping(value = "/author/showbyheat",method = RequestMethod.GET )
    public ResponseVO showAuthorInfoByHeat(){
        return authorDisplayService.showAuthorByHeat();
    }

    @RequestMapping(value = "/author/showResearchDirection",method = RequestMethod.GET )
    public ResponseVO showResearchDirectionById(@RequestParam("id") String id){
        return authorDisplayService.showResearchDirectionById(id);
    }
}
