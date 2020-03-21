package com.example.demo;

import com.example.demo.common.Constant;
import com.example.demo.service.UserService;
import com.example.demo.thread.LoadUsers;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;

/**
 * @Author ZhuFangTao
 * @MethodName DemoApplication
 * @Description 启动类
 * @Date 3:03 下午 2020/3/11
 **/
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoApplication.class, args);
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
		ExecutorService fixedThreadPool = new ThreadPoolExecutor(2,20,200L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);
		CountDownLatch latch = new CountDownLatch(Constant.THREAD_NUM);
		for (int threadId = 0; threadId < Constant.THREAD_NUM; threadId++) {
			fixedThreadPool.submit(new LoadUsers(threadId,latch));
		}
		latch.await();
		fixedThreadPool.shutdown();
		System.out.println("加载数据线程执行完毕！");
	}

}
