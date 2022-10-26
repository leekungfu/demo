package com.vn.service.impl;

import com.vn.handlerEx.CustomAuthenticationException;
import com.vn.model.Member;
import com.vn.repository.MemberRepository;
import com.vn.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Member> memberOptional = memberRepository.findByEmail(email);
        if (memberOptional.isEmpty()) {
            throw new CustomAuthenticationException("Email invalid!");
        } else {
            Member member = memberOptional.get();

            return new User(member.getEmail(), member.getPassword(), member.getRoles()
                    .stream()
                    .map((u) -> new SimpleGrantedAuthority(u.getRole()))
                    .collect(Collectors.toSet()));
        }
    }
}
