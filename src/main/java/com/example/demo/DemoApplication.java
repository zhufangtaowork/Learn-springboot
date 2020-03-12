package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Author ZhuFangTao
 * @MethodName DemoApplication
 * @Description 启动类
 * @Date 3:03 下午 2020/3/11
 **/
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
