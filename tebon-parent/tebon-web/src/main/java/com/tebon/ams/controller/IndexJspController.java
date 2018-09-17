package com.tebon.ams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-14
 **/
@Controller
public class IndexJspController {
    @RequestMapping("/jspIndex")
    public String index(Map<String,Object> map) {
        map.put("name","SpringBoo项目演示...");
        return "index";
    }

}
