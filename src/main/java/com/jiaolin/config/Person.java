package com.jiaolin.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author johnny
 * @Classname Person
 * @Description
 * @Date 2022/4/9 21:29
 */
@Data
//@Component
//@ConfigurationProperties(prefix = "person")
//@ToString
public class Person {
    private String userName;
}
