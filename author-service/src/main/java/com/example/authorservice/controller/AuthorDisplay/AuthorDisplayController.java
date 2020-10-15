package com.example.authorservice.controller.AuthorDisplay;

import com.example.authorservice.bl.AuthorDisplay.AuthorDisplayService;
import com.example.authorservice.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseVO getAuthorInfoByName(@RequestParam("name") String name){
        return authorDisplayService.getAuthorInfoByName(name);
    }
}
