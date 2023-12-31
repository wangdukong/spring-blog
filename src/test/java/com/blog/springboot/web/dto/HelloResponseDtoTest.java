package com.blog.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name="test";
        int amount=1000;

        //when
        HelloResponseDto dto=new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);//assertThat 검증하고 싶은 대상을 메소드 인자로 받음, 체이닝 지원
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
