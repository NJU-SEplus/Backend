package com.example.oasisdemo.controller.AuthorDisplay;

import com.example.oasisdemo.bl.AuthorDisplay.AuthorDisplayService;
import com.example.oasisdemo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://101.132.151.29", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, maxAge = 60L)
@RestController
public class AuthorDisplayController {
    @Autowired
    private AuthorDisplayService authorDisplayService;

    @RequestMapping(value = "/browse/TopTenPublicationAuthor", method = RequestMethod.GET)
    public ResponseVO searchTopTenReferenceDocument(){
        return authorDisplayService.searchTopTenPublicationAuthor();
    }

    @RequestMapping(value = "/Portrait/Author", method = RequestMethod.GET)
    public ResponseVO showAllAuthor(){
        return authorDisplayService.searchAllAuthor();
    }

    @RequestMapping(value = "/Portrait/Author/id/{author_id}", method = RequestMethod.GET)
    public ResponseVO showAuthorById(@PathVariable int author_id){
        return authorDisplayService.searchAuthorPortraitById(author_id);
    }

    @RequestMapping(value = "/Portrait/Author/name/{name}", method = RequestMethod.GET)
    public ResponseVO showAuthorByName(@PathVariable String name){
        return authorDisplayService.searchAuthorByName(name);
    }

    @RequestMapping(value = "/Portrait/Author/Hindex/{id}")
    public  ResponseVO getAuthorHindex(@PathVariable("id") int id){
        return authorDisplayService.getAuthorHindexById(id);
    }

    @RequestMapping(value = "/Portrait/Author/Partners/{id}",method = RequestMethod.GET)
    public ResponseVO getAuthorPartners(@PathVariable("id") int id){
        return authorDisplayService.getAuthorPartnersById(id);
    }

    @RequestMapping(value = "/Portrait/Author/showNewRelationById/{id}", method = RequestMethod.GET)
    public ResponseVO showNewRelationById(@PathVariable("id") int id){
        return authorDisplayService.showRelationByAuthorId(id);
    }

    @RequestMapping(value = "/Portrait/Author/showABRelation")
    public ResponseVO showABRelation(@RequestParam("authorAId") int Aid,
                                     @RequestParam ("authorBId") int Bid){
        return authorDisplayService.showABRelation(Aid,Bid);
    }

    @RequestMapping(value = "/Portrait/Author/showByHeat", method = RequestMethod.GET)
    public ResponseVO showByHeat(){
        return authorDisplayService.showAuthorByHeat();
    }

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
