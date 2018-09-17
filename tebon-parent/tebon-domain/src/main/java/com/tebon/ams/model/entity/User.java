package com.tebon.ams.model.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-14
 **/
@Slf4j
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;

}
