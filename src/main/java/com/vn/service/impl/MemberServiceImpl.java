package com.vn.service.impl;

import com.vn.dto.MemberDTO;
import com.vn.model.Member;
import com.vn.model.Role;
import com.vn.repository.MemberRepository;
import com.vn.repository.RoleRepository;
import com.vn.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Integer save(Member member) {
        Optional<Role> roleOptional = roleRepository.findByRole("USER");
        Role role = new Role();

        if (roleOptional.isPresent()) {
                role = roleOptional.get();
        } else {
            role.setRole("USER");
            role = roleRepository.save(role);
        }

        member.setUsername(member.getUsername());
        member.setEmail(member.getEmail());
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setCreatedDate(LocalDate.now());
        role.getMembers().add(member);
        member.getRoles().add(role);

        return memberRepository.save(member).getId();
    }

    @Override
    public Member findByUserAndEmail(String username, String email) {
        return memberRepository.findByUsernameAndEmail(username, email);
    }

    @Override
    public Member findByEmailAndPassword(String email, String enCodePassword) {
        return memberRepository.findByEmailAndPassword(email, enCodePassword);
    }
}
