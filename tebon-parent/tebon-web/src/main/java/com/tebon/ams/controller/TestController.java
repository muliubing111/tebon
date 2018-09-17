package com.tebon.ams.controller;

import com.tebon.ams.Service.TestService;
import com.tebon.ams.service.TebonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-14
 **/
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TebonService tebonService;

    @RequestMapping(value="hello")
    public String getValue(){
        int i = 1/0;
        return tebonService.getService();
    }
}
