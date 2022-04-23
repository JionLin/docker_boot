package com.jiaolin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author johnny
 * @Classname DockerBootApplication
 * @Description
 * @Date 2022/3/19 4:21 下午
 */

@SpringBootApplication
@MapperScan("com.jiaolin.mapper")
public class DockerBootApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DockerBootApplication.class, args);
    }

}