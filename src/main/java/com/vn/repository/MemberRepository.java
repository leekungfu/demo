package com.vn.repository;

import com.vn.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByEmail(String email);

    Member findByUsernameAndEmail(String username, String email);

    Member findByEmailAndPassword(String email, String password);

}
