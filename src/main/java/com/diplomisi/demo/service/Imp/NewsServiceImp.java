package com.diplomisi.demo.service.Imp;

import com.diplomisi.demo.repository.NewsRepository;
import com.diplomisi.demo.model.News;
import com.diplomisi.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class NewsServiceImp implements NewsService {
    @Autowired
    NewsRepository newsRepository;
    @Override
    public void save(String title, MultipartFile image, String content, String url) {
        News news=new News();
        news.setTitle(title);
try {
    news.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
}
catch (IOException e){e.printStackTrace();}

        news.setContent(content);
        news.setShortContent(contentSplit(content));
        news.setUrl(url);
        newsRepository.save(news);
    }

    @Override
    public List<News> newslist() {
        return newsRepository.findAll();
    }

    @Override
    public String contentSplit(String content) {
        List<Character> list=new ArrayList<>();
        if(content.length()>150)
        {
            for(int i=0;i<150;i++)
            {

                list.add(content.charAt(i));
                //System.out.print( content.charAt(i));
            }
        }
        else for(int i=0;i<content.length();i++)
        {

            list.add(content.charAt(i));
            //System.out.print( content.charAt(i));
        }

        StringBuilder string=new StringBuilder();
        for(Character chr : list)
            string.append(chr);
        String result=string.toString();
        System.out.println(result);
        result=result+"[.]";
        return result;

    }

    @Override
    public News findById(Long id) {
        return newsRepository.findById(id).get();
    }
}
