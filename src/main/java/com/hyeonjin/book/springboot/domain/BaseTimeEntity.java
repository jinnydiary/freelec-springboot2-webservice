package com.hyeonjin.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 해당 클래스 상속 시 필드들(createdDate, modifiedDate)도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 Auditing 기능 포함
public abstract class BaseTimeEntity { //모든 Entity의 상위 클래스(Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할)

    @CreatedDate //Entity 생성되어 저장 시 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값 변경 시 시간 자동 저장
    private LocalDateTime modifiedDate;

}
