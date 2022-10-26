package com.vn.service.impl;

import com.vn.model.Content;
import com.vn.repository.ContentRepository;
import com.vn.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;
    @Override
    public List<Content> findByAuthorId(Integer id) {
        return contentRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public void delete(Integer id) {
        contentRepository.deleteById(id);

    }

    @Override
    public void save(Content content) {
        contentRepository.save(content);
    }
}
