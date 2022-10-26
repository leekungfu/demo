package com.vn.service;

import com.vn.dto.MemberDTO;
import com.vn.model.Member;

import java.util.Optional;

public interface MemberService {
    Integer save(Member member);

    Member findByUserAndEmail(String username, String email);

    Member findByEmailAndPassword(String email, String enCodePassword);

//    Optional<Member> findByEmailAndPassword(String email, String enCodePassword);
}
