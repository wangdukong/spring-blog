package com.blog.springboot.web;

import com.blog.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러가 JSON을 반환하게 만들어줌
public class HelloController {

    @GetMapping("/hello") // HTTP Method 인 GET의 요청을 받을 수 있는 API 생성
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name,@RequestParam("amount") int amount)
    {
        return new HelloResponseDto(name, amount);
    }
}
