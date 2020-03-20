package com.example.demo;

import com.example.demo.untils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
@Autowired
private RedisUtil redisUtil;
	@Test
	void contextLoads() {
		try {
			redisUtil.set("xz","缓存测试");
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
