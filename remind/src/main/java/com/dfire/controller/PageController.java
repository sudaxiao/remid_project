package com.dfire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xiaosuda on 2017/9/1.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/{pageName}")
    public ModelAndView pageSkip(@PathVariable("pageName") String pageName){
        ModelAndView modelAndView =new ModelAndView("index");
        modelAndView.addObject("name",pageName);
        return modelAndView;
    }
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "why?";
    }
}
