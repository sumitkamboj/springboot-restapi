package com.sumit.springboot.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.sumit.springboot.restful.DTO.TagMetricsDTO;

@SpringBootApplication
@EnableEurekaClient
@EntityScan
//@ComponentScan("com.sumit.springboot.restful.DTO")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
/*	private TagMetricsDTO tagMetricsDTO;
	@Bean
    public TagMetricsDTO getTagMetricsDTO() {
    	return new TagMetricsDTO();
    }*/
}
