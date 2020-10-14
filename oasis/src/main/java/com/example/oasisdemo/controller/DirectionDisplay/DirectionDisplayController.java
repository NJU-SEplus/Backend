package com.example.oasisdemo.controller.DirectionDisplay;


import com.example.oasisdemo.bl.DirectionDisplay.DirectionDisplayService;
import com.example.oasisdemo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectionDisplayController {
    @Autowired
    private DirectionDisplayService directionDisplayService;

    @RequestMapping(value = "/Portrait/Direction", method = RequestMethod.GET)
    public ResponseVO showAllDirection(){
        return directionDisplayService.showAllDirection();
    }

    @RequestMapping(value = "/Portrait/Direction/id/{direction_id}", method = RequestMethod.GET)
    public ResponseVO showDirectionnById(@PathVariable int direction_id){
        return directionDisplayService.getDirectionPortrait(direction_id);
    }
    @RequestMapping(value = "/Portrait/Direction/name/{name}", method = RequestMethod.GET)
    public ResponseVO showDirectionByName(@PathVariable String name){
        return directionDisplayService.getDirectionByName(name);
    }
    @RequestMapping(value = "/Portrait/Direction/showByHeat", method = RequestMethod.GET)
    public ResponseVO showDirectionByHeat(){
        return directionDisplayService.showDirectionByHeat();
    }
}
