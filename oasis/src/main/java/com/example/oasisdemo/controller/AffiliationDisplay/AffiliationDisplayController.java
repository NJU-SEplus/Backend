package com.example.oasisdemo.controller.AffiliationDisplay;

import com.example.oasisdemo.bl.AffiliationDisplay.AffiliationDisplayService;
import com.example.oasisdemo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AffiliationDisplayController {
    @Autowired
    private AffiliationDisplayService affiliationDisplayService;

    @RequestMapping(value = "/Portrait/Affiliation", method = RequestMethod.GET)
    public ResponseVO showAllAffiliation(){
        return affiliationDisplayService.showAllAffiliation();
    }

    @RequestMapping(value = "/Portrait/Affiliation/id/{affiliation_id}", method = RequestMethod.GET)
    public ResponseVO showAffiliationById(@PathVariable int affiliation_id){
        return affiliationDisplayService.getAffiliationPortrait(affiliation_id);
    }
    @RequestMapping(value = "/Portrait/Affiliation/name/{name}", method = RequestMethod.GET)
    public ResponseVO showAffiliationByName(@PathVariable String name){
        return affiliationDisplayService.getAffiliationByName(name);
    }
    @RequestMapping(value = "/Portrait/Affiliation/showByCountry", method = RequestMethod.GET)
    public ResponseVO showByCountry(){
        return affiliationDisplayService.showAffiliationByCountry();
    }

    @RequestMapping(value = "/Portrait/Affiliation/showByHeat", method = RequestMethod.GET)
    public ResponseVO showByHeat(){
        return affiliationDisplayService.showAffiliationByHeat();
    }

    @RequestMapping(value = "/Portrait/Affiliation/showNewRelationByName/{affiliationName}", method = RequestMethod.GET)
    public ResponseVO showNewRelationByName(@PathVariable String affiliationName){
        return affiliationDisplayService.showRelationByName(affiliationName);
    }
}
