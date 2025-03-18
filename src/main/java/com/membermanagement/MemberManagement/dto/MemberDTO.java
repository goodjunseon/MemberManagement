package com.membermanagement.MemberManagement.dto;


import com.membermanagement.MemberManagement.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 생성자 생성 알아서 해줌, final 변수 그냥 선언 가능
@ToString
public class MemberDTO {
    private Long id; // PK auto_increment
    private String memberEmail; // Email(아이디)
    private String memberPassword; // 비밀번호
    private String memberName; // 이름
    private String memberTel; // 전화번호
    private String memberDate; // 생년월일 YYYY-MM-DD

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberTel(memberEntity.getMemberTel());
        memberDTO.setMemberDate(memberEntity.getMemberDate());

        return memberDTO;
    }
}
