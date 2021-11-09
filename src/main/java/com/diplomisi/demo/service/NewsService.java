package com.diplomisi.demo.service;

import com.diplomisi.demo.model.News;
import com.diplomisi.demo.service.Imp.NewsServiceImp;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NewsService {
    void save(String title, MultipartFile image, String content, String url);
    List<News> newslist();
    String contentSplit(String content);
    News findById(Long id);
}

