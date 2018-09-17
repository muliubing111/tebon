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
public class FtlTemplateController {

    @RequestMapping(value = "index.do")
    public String index(Map<String,Object> map){
        map.put("name","1222sss2221fff1");
        return "index";
    }
}
