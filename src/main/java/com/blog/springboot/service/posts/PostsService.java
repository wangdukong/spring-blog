package com.blog.springboot.service.posts;


import com.blog.springboot.domain.posts.Posts;
import com.blog.springboot.domain.posts.PostsRepository;
import com.blog.springboot.web.dto.PostsListResponseDto;
import com.blog.springboot.web.dto.PostsResponseDto;
import com.blog.springboot.web.dto.PostsSaveRequestDto;
import com.blog.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.*;
@RequiredArgsConstructor
@Service //autowired는 추천되지 않는다.
//bean 주입방식은 autowired, setter, 생성자
//@RequiredArgsConstructor 사용해 repositiory 빈 주입
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts=postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity=postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
    @Transactional(readOnly = true) // 조회기능만 가능한 트랜잭션
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
        //postsRepository 결과로 넘어온 posts의 stream을 map을 이용해 PostsListsResponseDto로 반환에서 List로 반환하는 메소드
    }

    @Transactional
    public void delete(Long id){
        Posts posts =postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }
}
