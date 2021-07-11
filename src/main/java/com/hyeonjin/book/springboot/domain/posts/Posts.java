package com.hyeonjin.book.springboot.domain.posts;
import com.hyeonjin.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //Lombok의 어노테이션, 클래스 내 모든 Getter 메서드 자동생성
@NoArgsConstructor //Lombok의 어노테이션, 기본생성자 자동 추가
@Entity //JPA의 어노테이션(주석), 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity { //실제 DB 테이블과 매칭될 클래스로 보통 Entity 클래스

    @Id //해당 테이블의 PK 필드 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙, IDENTITY 사용함으로서 autho_increment 됨
    private Long id;

    @Column(length = 500, nullable = false) //기본키 외에 추가로 변경이 필요한 옵션이 있으면 사용
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) { //기본 생성자
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
