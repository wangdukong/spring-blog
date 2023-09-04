package com.blog.springboot.web;

import com.blog.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class) //Junit에 내장된 실행자 외에 다른 실행자를 실행시킴
@WebMvcTest(controllers = HelloController.class) // Web에 집중할 수 있는 test 어노테이션
//@SpringJUnitConfig(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; //웹 API 테스할때 사용. HTTP GET,POST등에 대한 api 테스트 가능.

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello="hello";
        mvc.perform(get("/hello"))// /hello 주소로 get요청
                .andExpect(status().isOk())// perform의 결과 검증 status가 200인지 확인
                .andExpect(content().string(hello));// 응답 본문의 내용이 hello인지 검증
    }

    @Test
    public void DTO가_리턴된다() throws Exception{
        String name="name";
        int amount=1000;

        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))
                //param api테스트할떄 사용될 요청 파라미터 설정 but only String
                .andExpect(status().isOk())
                //jsonpath json응답값(RestController 응답값)을 필드별로 검증할수 있는 메소드
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }

}
