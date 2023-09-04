package com.blog.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링 부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로
// 항상 이 어노테이션부터 읽어가기에 프로젝트 최상단에 위치.
public class Application { //프로젝트의 메인클래스
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
