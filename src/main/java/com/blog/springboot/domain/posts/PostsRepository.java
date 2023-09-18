package com.blog.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Entity 클래스와 Repository 인터페이스는 같은 패키지에 위치해야 한다.
public interface PostsRepository extends JpaRepository<Posts,Long> {//JpaRepository<Entity 클래스명,PK 타입>
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
