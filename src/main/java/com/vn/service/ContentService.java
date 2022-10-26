package com.vn.service;

import com.vn.model.Content;

import java.util.List;

public interface ContentService {
    List<Content> findByAuthorId(Integer id);

    void delete(Integer id);

    void save(Content content);
}
