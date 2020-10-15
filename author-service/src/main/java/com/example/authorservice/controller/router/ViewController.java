package com.example.authorservice.controller.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zjy
 * @data 2020/3/4
 */
@Controller
public class ViewController {

    @RequestMapping(value = "/index")
    public String getIndex(){ return "index";}

    @RequestMapping(value = "/search")
    public String getSearch(){ return "search";}

    @RequestMapping(value = "/browse")
    public String getBrowse(){ return "browse";}

    @RequestMapping(value = "/about")
    public String getAbout(){ return "about";}

    @RequestMapping(value = "/search/display")
    public String getSearchDisplay(){ return "searchDisplay";}

    @RequestMapping(value = "/visual")
    public String getVisual(){return "visual";}

    @RequestMapping(value = "/test")
    public String getTest(){return "test";}
}
