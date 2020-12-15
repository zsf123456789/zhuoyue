package com.icis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.icis.mapper")//开启mapper包扫描
public class SpringbootMapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMapperApplication.class, args);
	}

}
