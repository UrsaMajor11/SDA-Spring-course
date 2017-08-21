package com.sda.SDASpringcourse.controller;

import com.sda.SDASpringcourse.model.News;
import com.sda.SDASpringcourse.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by RENT on 2017-08-17.
 */

@Controller
@RequestMapping(path = "/news")
public class NewsController {

    @Autowired
    NewsRepository newsRepository;

    //1 - wyswietlenie wszystkich newsow

    @GetMapping
    public ModelAndView allNews() {
        ModelAndView modelAndView = new ModelAndView("allNews");

        List<News> all = newsRepository.getAll();

        modelAndView.addObject("allNews", all);

        return modelAndView;
    }

    //2 - wyswietlenie zadanego newsa po parametrze w adresie

    @GetMapping(value = "/{newsId}")
    public ModelAndView newsById(@PathVariable("newsId") String newsId) {
        ModelAndView modelAndView = new ModelAndView("news");

        News byId = newsRepository.getById(Integer.valueOf(newsId));

        modelAndView.addObject("singleNews", byId);

        return modelAndView;
    }

}
