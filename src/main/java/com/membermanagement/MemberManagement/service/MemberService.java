package com.membermanagement.MemberManagement.service;

import com.membermanagement.MemberManagement.dto.MemberDTO;
import com.membermanagement.MemberManagement.entity.MemberEntity;
import com.membermanagement.MemberManagement.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        // 1. dto -> entity 객체로 변환
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);

        // 2. repository의 save 메서드 호출
        // repository save메서드 호출 (조건. entity 객체를 넘겨줘야 함)
        memberRepository.save(memberEntity);

    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
        * 1, 회원이 입력한 이메일로 DB에서 조회를 한다.
        * 2. DB에서 조회한 비밀번호와 회원이 입력한 비밀번호가 일치하는지 판단한다.
        * */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            // 조회 결과 존재 (해당 이메일을 가진 정보가 있음)
            MemberEntity memberEntity = byMemberEmail.get();
            if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호 일치할 때
                // entity -> dto 변환 후 리턴

                return memberDTO;
            }else {
                // 비밀번호 일치 X
                return null;
            }
        } else {
            // 조회 결과 존재X  해당 이메일을 가진 정보 없음)
            return null;
        }

    }

    public List<MemberDTO> findAll() {
        // memberRepository에서 findAll -> 여러개의 memberEntity의 값들이 memberEntityList에 저장
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        // memberEntityList(여러개)의 값들을 memberDTOList에 저장하려하는데, toMemberDTO는 하나의 Entity를 DTO로 넘겨주는 함수임
        List<MemberDTO> memberDTOList = new ArrayList<>();
        // 그래서 for문으로 리스트 요소를 반복해서 memberDTOList의 List.add()를 이용해서 하나씩 삽입함
        for (MemberEntity memberEntity : memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }

        return memberDTOList;
    }


    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public MemberDTO updateForm(String myEmail) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberEmail(myEmail);
        if(optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    public String emailCheck(String memberEmail) {
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberEmail);
        if (byMemberEmail.isPresent()) {
            // 조회 결과가 있다 -> 사용할 수 없다.
            return null;
        } else {
            //조회 결과가 없다 -> 사용할 수 있다.
            return "ok";
        }
    }
}
