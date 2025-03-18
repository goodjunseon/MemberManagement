package com.sundayleague.SundayLeague.service;

import com.sundayleague.SundayLeague.dto.MemberDTO;
import com.sundayleague.SundayLeague.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
    }
}
