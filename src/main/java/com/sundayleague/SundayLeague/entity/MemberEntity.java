package com.sundayleague.SundayLeague.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "member_table") //DB에 생성될 테이블 명 : member_table
public class MemberEntity {
    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true) // unique 제약조건 추가 (중복 처리)
    private String memberEmail;

    @Column()
    private String memberPassword; // 비밀번호

    @Column
    private String memberName; // 이름

    @Column
    private String memberTel; // 전화번호

    @Column
    private String memberDate; // 생년월일 YYYY-MM-DD

}
