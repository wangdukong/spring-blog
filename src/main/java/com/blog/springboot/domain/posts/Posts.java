package com.blog.springboot.domain.posts;


import com.blog.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //Get
@NoArgsConstructor //기본생성자 자동생성
@Entity //테이블과 링크될 클래스 임을 명시, 클래스의 카멜케이스 이름을 _네이밍으로 테이블 이름을 매칭
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK의 생성 규칙
    private Long id;

    @Column(length = 500, nullable=false)//테이블 컬럼을 나타냄 선언하지 않아도 클래스의 필드는 컬럼이 되지만 옵션을 추가하기 위해 선언
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //생성자 상단에 선언시 생성자에 포함된 빌드만 빌더에 포함.
    public Posts(String title,String content, String author)
    {
        this.title=title;
        this.content=content;
        this.author=author;

    }
    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }
}
// Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다
// 해당 필드의 값 변경이 필요하다면, 명확히 목적과 의도가 드러나는 메소드를 생성
// ex) 주문취소 -> cancelOrder(){this.status=false};
// Entity 클래스는 생성자를 통해 값을 생성한다.