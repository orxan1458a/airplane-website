package com.diplomisi.demo.repository;

import com.diplomisi.demo.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

}
