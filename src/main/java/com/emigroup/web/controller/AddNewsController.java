package com.emigroup.web.controller;

import com.emigroup.web.service.NewsService;
import com.emigroup.web.vo.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/addnews")
@Controller
public class AddNewsController {
    @Resource
    NewsService newsService;
    @ResponseBody
    @RequestMapping(value={"/addnews"},method=RequestMethod.POST)
    public String addNews(Model model, News news){
        newsService.addNews(news);
        System.out.println(news.getText());
        return "success";

    }

    @ResponseBody
    @RequestMapping(value={"/findall"},method=RequestMethod.POST)
    public List<News> findAll(){
        return newsService.findAll();
    }
    @ResponseBody
    @RequestMapping(value={"/findbyid"},method=RequestMethod.POST)
    public News findById(int id){
        return newsService.findById(id);

    }


}
