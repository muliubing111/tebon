package com.tebon.ams;

import com.tebon.ams.Service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-14
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebTest {

    @Autowired
    private TestService testService;

   @Test
   public void test1(){
    testService.getValue();
   }
}
