package com.diplomisi.demo.controller;

import com.diplomisi.demo.model.News;
import com.diplomisi.demo.repository.NewsRepository;
import com.diplomisi.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class PageController {
    @Autowired
    NewsService newsService;
    @Autowired
    NewsRepository newsRepository;
    @GetMapping("/home")
    public  String home(Model model)
    {
        List<News> lists=newsService.newslist();
        List<News> list =new ArrayList<>();
        for (int i = lists.size(); i-- > 0; )
        {
            list.add(lists.get(i));
        }
        model.addAttribute("list",list);

        Pageable paging = PageRequest.of(0,9);
        System.out.println("SEKILLER CAP OLUNDU");
        Page<News> newsPage=  newsRepository.findAll(paging);

        System.out.println("........");
        System.out.println(paging);
        int totalPages = newsPage.getTotalPages();
        int currentPage = 1;
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("currentPage",currentPage);

        return "home";}
    @GetMapping("/about")
    public String about(){return "about";}
    @GetMapping("/ourteam")
    public String ourteam(){
        return "ourteam";
    }
    @GetMapping("/newscreate")
    public String newsCreate(){
        return "newscreate";
        }
    @PostMapping("/home")
    public String newsCreate(@RequestParam("title")String title,
                             @RequestParam("image")MultipartFile image,
                             @RequestParam("content")String content,
                             @RequestParam("url")String url){
        System.out.println(title);
        System.out.println(image);
        newsService.save(title,image,content,url);

        return "redirect:/home";
    }
    @GetMapping("/news/view")
    public String newsView(Model  model,@RequestParam("id")Long id)
    {
        News news=newsService.findById(id);
        //System.out.println(sharing.getContent());
        model.addAttribute("news",news);
        return "newsview";
    }


}
