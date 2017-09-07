package com.dfire;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.dfire")
@MapperScan("com.dfire.mapper")
public class RemindApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemindApplication.class, args);
	}
	@RequestMapping("/")
	String home(){
		return "redirect:page/index";
	}
}
