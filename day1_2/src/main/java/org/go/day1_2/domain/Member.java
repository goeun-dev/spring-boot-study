package org.go.day1_2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Member
 * 
 * @Entity: 테이블과 매핑
 * @Table(name = "t_member"): 실제 DB의 테이블명을 지정. 생략 시 클래스명으로 테이블명 인식.
 * @Data
 * @Builder
 * @NoArgsConstructor: JPA 엔티티 클래스 - 기본 생성자 필요.
 * @AllArgsConstructor: @Builder와 @NoArgsConstructor를 함께 사용 시, 모든 필드 가지는 생성자 필요.
 * 
 */
@Entity
@Table(name = "t_member")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    // pk와 매핑
    @Id
    private String mid;

    private String mpw;

    private String mname;
    
}