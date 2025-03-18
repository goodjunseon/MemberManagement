package com.membermanagement.MemberManagement.repository;

import com.membermanagement.MemberManagement.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional; // Option : Null 방지 클래스

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
 // JpaRepository<MemberEntity, Long> MemberEntity의 PK 자료형은 Long으로 설정한 것임.

    // 이메일로 회원 정보 조회 (select * from member_table where member_email=?)
    Optional <MemberEntity> findByMemberEmail(String memberEmail);



}
