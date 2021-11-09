package com.diplomisi.demo.service;

import com.diplomisi.demo.model.PartOfAirplane;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

public interface PartService {
    void save(String name,
              MultipartFile image,
              String brand, String color,
              BigDecimal price,
              String country,
              Date date,
              Double weight
              );
    List<PartOfAirplane> list();
}
