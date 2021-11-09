package com.diplomisi.demo.controller;

import com.diplomisi.demo.model.News;
import com.diplomisi.demo.model.PartOfAirplane;
import com.diplomisi.demo.repository.NewsRepository;
import com.diplomisi.demo.service.NewsService;
import com.diplomisi.demo.service.PartService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PartController {
    @Autowired
    NewsRepository repository;
    @Autowired
    PartService partService;
    @GetMapping("/partpage")
    public String sellingPart(Model model){
        List<PartOfAirplane> list=partService.list();
        model.addAttribute("list",list);

        return "partpage";
    }
    @PostMapping("/partpage")
    public String partCreate(@RequestParam("name")String title,
                             @RequestParam("image")MultipartFile image,
                             @RequestParam("brand")String brand,
                             @RequestParam("color")String color,
                             @RequestParam("price") BigDecimal price,
                             @RequestParam("country")String country,
                             @RequestParam("date")Date date,
                             @RequestParam("weight")Double weight){
        partService.save(title,image,brand,color,price,country,date,weight);
        return "partcreate";
    }
    @GetMapping("/partcreate")
    public String partCreate()
    {
        return "partcreate";
    }

    @GetMapping("/js")
    public String js()
    {
        return "javascript";
    }

}
