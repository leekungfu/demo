package com.vn.repository;

import com.vn.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ContentRepository extends JpaRepository<Content, Integer> {
}
